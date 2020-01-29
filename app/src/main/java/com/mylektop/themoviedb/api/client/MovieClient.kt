package com.mylektop.themoviedb.api.client

import com.mylektop.themoviedb.api.ApiResponse
import com.mylektop.themoviedb.api.async
import com.mylektop.themoviedb.api.service.MovieService
import com.mylektop.themoviedb.models.entity.MovieDetail
import com.mylektop.themoviedb.models.network.MovieResponse

/**
 * Created by MyLektop on 29/01/2020
 */
class MovieClient(private val service: MovieService) {
    fun fetchMoviePopular(
        page: Int,
        onResult: (response: ApiResponse<MovieResponse>) -> Unit
    ) {
        this.service.fetchMoviePopular(page).async(onResult)
    }

    fun fetchMovieDetail(
        movieId: Int,
        onResult: (response: ApiResponse<MovieDetail>) -> Unit
    ) {
        this.service.fetchMovieDetail(movieId).async(onResult)
    }
}