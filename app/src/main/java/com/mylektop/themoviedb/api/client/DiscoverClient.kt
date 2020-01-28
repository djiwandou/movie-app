package com.mylektop.themoviedb.api.client

import com.mylektop.themoviedb.api.ApiResponse
import com.mylektop.themoviedb.api.async
import com.mylektop.themoviedb.api.service.DiscoverService
import com.mylektop.themoviedb.models.network.DiscoverMovieResponse

/**
 * Created by MyLektop on 28/01/2020
 */
class DiscoverClient(private val service: DiscoverService) {
    fun fetchDiscoverMovie(
        page: Int,
        onResult: (response: ApiResponse<DiscoverMovieResponse>) -> Unit
    ) {
        this.service.fetchDiscoverMovie(page).async(onResult)
    }
}