package com.mylektop.themoviedb.view.ui.main

import android.os.Bundle
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.mylektop.themoviedb.R
import com.mylektop.themoviedb.compose.ViewModelActivity
import com.mylektop.themoviedb.databinding.ActivityMainBinding
import com.mylektop.themoviedb.models.entity.Movie
import com.mylektop.themoviedb.view.adapter.MovieListAdapter
import com.mylektop.themoviedb.view.ui.detail.DetailActivity
import com.mylektop.themoviedb.view.viewholder.MovieListViewHolder
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by MyLektop on 28/01/2020
 */
class MainActivity : ViewModelActivity(), MovieListViewHolder.Delegate {

    private val mainViewModel by viewModel<MainViewModel>()
    private val binding by binding<ActivityMainBinding>(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadMore(page = 1)

        with(binding) {
            lifecycleOwner = this@MainActivity
            viewModel = mainViewModel
        }

        initializeUI()
        observeMessages()
    }

    override fun onItemClick(movie: Movie) = DetailActivity.startActivityModel(this, movie)

    private fun initializeUI() {
        recyclerViewMovie.adapter = MovieListAdapter(this)
        recyclerViewMovie.layoutManager = GridLayoutManager(this, 2)

        RecyclerViewPaginator(
            recyclerView = recyclerViewMovie,
            isLoading = { false },
            loadMore = { loadMore(it) },
            onLast = { false }
        ).apply {
            threshold = 4
            currentPage = 1
        }
    }

    private fun loadMore(page: Int) = mainViewModel.postMoviePage(page)

    private fun observeMessages() = this.mainViewModel.toastLiveData.observe(this) { toast(it) }
}
