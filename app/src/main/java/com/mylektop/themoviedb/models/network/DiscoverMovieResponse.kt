package com.mylektop.themoviedb.models.network

import com.mylektop.themoviedb.models.NetworkResponseModel
import com.mylektop.themoviedb.models.entity.Movie

/**
 * Created by MyLektop on 28/01/2020
 */
class DiscoverMovieResponse(
    val page: Int,
    val total_results: Int,
    val total_pages: Int,
    val results: List<Movie>
) : NetworkResponseModel