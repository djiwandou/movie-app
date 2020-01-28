package com.mylektop.themoviedb.repository

import androidx.lifecycle.MutableLiveData
import com.mylektop.themoviedb.api.ApiResponse
import com.mylektop.themoviedb.api.client.DiscoverClient
import com.mylektop.themoviedb.api.message
import com.mylektop.themoviedb.models.entity.Movie
import com.mylektop.themoviedb.room.MovieDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Created by MyLektop on 28/01/2020
 */
class DiscoverRepository constructor(
    private val discoverClient: DiscoverClient,
    private val movieDao: MovieDao
) : Repository {
    suspend fun loadMovies(page: Int, error: (String) -> Unit) = withContext(Dispatchers.IO) {
        val liveDate = MutableLiveData<List<Movie>>()
        var movies = movieDao.getMovieList(page)
        if (movies.isEmpty()) {
            discoverClient.fetchDiscoverMovie(page) { response ->
                when (response) {
                    is ApiResponse.Success -> {
                        response.data?.let { data ->
                            movies = data.results
                            movies.forEach { it.page = page }
                            liveDate.postValue(movies)
                            movieDao.insertMovieList(movies)
                        }
                    }
                    is ApiResponse.Failure.Error -> error(response.message())
                    is ApiResponse.Failure.Exception -> error(response.message())
                }
            }
        }
        liveDate.apply { postValue(movies) }
    }
}