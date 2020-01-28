package com.mylektop.themoviedb.view.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.mylektop.themoviedb.api.Api
import com.mylektop.themoviedb.models.entity.Movie
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by MyLektop on 28/01/2020
 */
class MovieListViewHolder(
    val view: View,
    private val delegate: Delegate
) : BaseViewHolder(view) {

    interface Delegate {
        fun onItemClick(movie: Movie)
    }

    private lateinit var movie: Movie

    @Throws(Exception::class)
    override fun bindData(data: Any) {
        if (data is Movie) {
            movie = data

            itemView.run {
                item_movie_title.text = movie.title
                item_movie_overview.text = movie.overview

                movie.poster_path?.let {
                    Glide.with(context)
                        .load(Api.getPosterPath(it))
                        .into(item_movie_post)
                }
            }
        }
    }

    override fun onClick(v: View?) = delegate.onItemClick(movie)

    override fun onLongClick(v: View?) = false
}