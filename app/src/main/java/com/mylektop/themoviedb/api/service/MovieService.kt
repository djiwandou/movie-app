package com.mylektop.themoviedb.api.service

import com.mylektop.themoviedb.models.entity.MovieDetail
import com.mylektop.themoviedb.models.network.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by MyLektop on 29/01/2020
 */
interface MovieService {
    @GET("movie/popular")
    fun fetchMoviePopular(@Query("page") page: Int): Call<MovieResponse>

    @GET("movie/{movie_id}")
    fun fetchMovieDetail(@Path("movie_id") id: Int): Call<MovieDetail>
}