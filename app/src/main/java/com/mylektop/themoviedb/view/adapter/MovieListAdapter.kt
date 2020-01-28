package com.mylektop.themoviedb.view.adapter

import android.view.View
import com.mylektop.themoviedb.R
import com.mylektop.themoviedb.models.entity.Movie
import com.mylektop.themoviedb.view.viewholder.MovieListViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.SectionRow

/**
 * Created by MyLektop on 28/01/2020
 */
class MovieListAdapter(private val delegate: MovieListViewHolder.Delegate) : BaseAdapter() {

    init {
        addSection(ArrayList<Movie>())
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_movie

    override fun viewHolder(layout: Int, view: View) = MovieListViewHolder(view, delegate)

    fun addMovieList(movies: List<Movie>) {
        val section = sections()[0]
        section.addAll(movies)
        notifyItemRangeInserted(section.size + 1, movies.size)
    }
}