package com.mylektop.themoviedb.binding

import android.annotation.SuppressLint
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mylektop.themoviedb.R
import com.mylektop.themoviedb.api.Api
import com.mylektop.themoviedb.models.entity.Movie
import com.skydoves.whatif.whatIfNotNull

/**
 * Created by MyLektop on 29/01/2020
 */
@BindingAdapter("bindBackDrop")
fun bindBackDrop(view: AppCompatImageView, movie: Movie) {
    movie.backdrop_path.whatIfNotNull(
        whatIf = {
            Glide.with(view.context)
                .load(Api.getBackdropPath(it))
                .placeholder(R.mipmap.ic_launcher)
                .into(view)
        },
        whatIfNot = {
            Glide.with(view.context)
                .load(Api.getBackdropPath(movie.poster_path))
                .placeholder(R.mipmap.ic_launcher)
                .into(view)
        }
    )
}

@SuppressLint("SetTextI18n")
@BindingAdapter("bindReleaseDate")
fun bindReleaseDate(view: AppCompatTextView, movie: Movie) {
    view.text = "Release Date : ${movie.release_date}"
}

@BindingAdapter("bindVoteAverage")
fun bindVoteAverage(view: AppCompatTextView, movie: Movie) {
    view.text = movie.vote_average.toString()
}