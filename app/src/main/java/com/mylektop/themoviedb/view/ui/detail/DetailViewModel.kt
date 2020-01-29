package com.mylektop.themoviedb.view.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.mylektop.themoviedb.compose.DispatchViewModel
import com.mylektop.themoviedb.models.entity.MovieDetail
import com.mylektop.themoviedb.repository.MovieRepository

/**
 * Created by MyLektop on 29/01/2020
 */
class DetailViewModel
constructor(private val movieRepository: MovieRepository) : DispatchViewModel() {

    private val movieIdLiveData: MutableLiveData<Int> = MutableLiveData()
    val movieDetailLiveData: LiveData<MovieDetail>
    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        this.movieDetailLiveData = movieIdLiveData.switchMap { id ->
            launchOnViewModelScope {
                movieRepository.loadMovieDetail(id) { toastLiveData.postValue(it) }
            }
        }
    }

    fun postMovieId(id: Int) = movieIdLiveData.postValue(id)
}