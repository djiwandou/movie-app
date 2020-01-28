package com.mylektop.themoviedb.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mylektop.themoviedb.models.entity.Movie
import com.mylektop.themoviedb.view.adapter.MovieListAdapter
import com.skydoves.whatif.whatIfNotNull

/**
 * Created by MyLektop on 28/01/2020
 */
@BindingAdapter("adapterMovieList")
fun bindAdapterMovieList(view: RecyclerView, movies: List<Movie>?) {
    movies.whatIfNotNull {
        val adapter = view.adapter as? MovieListAdapter
        adapter?.addMovieList(it)
    }
}