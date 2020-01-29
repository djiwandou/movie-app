package com.mylektop.themoviedb.models.entity

import android.os.Parcelable
import com.mylektop.themoviedb.models.NetworkResponseModel
import kotlinx.android.parcel.Parcelize

/**
 * Created by MyLektop on 29/01/2020
 */
@Parcelize
data class MovieDetail(
    val budget: Int,
    val homepage: String?,
    val imdb_id: String?,
    val revenue: Int,
    val runtime: Int,
    val status: String?,
    val tagline: String?
) : Parcelable, NetworkResponseModel