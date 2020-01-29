package com.mylektop.themoviedb.models.entity

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

/**
 * Created by MyLektop on 28/01/2020
 */
@Parcelize
@Entity(tableName = "movie", primaryKeys = [("id")])
data class Movie(
    var page: Int,
    @Embedded var movieDetail: MovieDetail? = null,
    val popularity: Float,
    val vote_count: Int,
    val video: Boolean,
    val poster_path: String?,
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String?,
    val original_language: String,
    val original_title: String,
    val title: String,
    val vote_average: Float,
    val overview: String,
    val release_date: String?
) : Parcelable