package com.mylektop.themoviedb.view.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.mylektop.themoviedb.compose.DispatchViewModel
import com.mylektop.themoviedb.models.entity.Movie
import com.mylektop.themoviedb.repository.DiscoverRepository

/**
 * Created by MyLektop on 28/01/2020
 */
class MainViewModel
constructor(private val discoverRepository: DiscoverRepository) : DispatchViewModel() {

    private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()
    val movieListLiveData: LiveData<List<Movie>>

    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        this.movieListLiveData = moviePageLiveData.switchMap { page ->
            launchOnViewModelScope {
                discoverRepository.loadMovies(page) {
                    toastLiveData.postValue(it)
                }
            }
        }
    }

    fun postMoviePage(page: Int) = moviePageLiveData.postValue(page)
}