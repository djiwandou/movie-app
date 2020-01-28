package com.mylektop.themoviedb.api.service

import com.mylektop.themoviedb.models.network.DiscoverMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by MyLektop on 28/01/2020
 */
interface DiscoverService {
    @GET("discover/movie?language=en&sort_by=popularity.desc")
    fun fetchDiscoverMovie(@Query("page") page: Int): Call<DiscoverMovieResponse>
}