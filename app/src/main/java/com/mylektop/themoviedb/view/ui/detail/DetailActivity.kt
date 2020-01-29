package com.mylektop.themoviedb.view.ui.detail

import android.app.Activity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.observe
import com.mylektop.themoviedb.R
import com.mylektop.themoviedb.compose.ViewModelActivity
import com.mylektop.themoviedb.databinding.ActivityDetailBinding
import com.mylektop.themoviedb.extension.applyToolbarMargin
import com.mylektop.themoviedb.extension.simpleToolbarWithHome
import com.mylektop.themoviedb.models.entity.Movie
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.koin.android.viewmodel.ext.android.viewModel

class DetailActivity : ViewModelActivity() {

    private val detailViewModel by viewModel<DetailViewModel>()
    private val binding by binding<ActivityDetailBinding>(R.layout.activity_detail)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailViewModel.postMovieId(getDataFromIntent().id)

        with(binding) {
            lifecycleOwner = this@DetailActivity
            viewModel = detailViewModel
            movie = getDataFromIntent()
        }

        initializeUI()
        observeMessages()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) onBackPressed()
        return false
    }

    private fun initializeUI() {
        applyToolbarMargin(detail_movie_toolbar)
        simpleToolbarWithHome(detail_movie_toolbar, getDataFromIntent().title)
    }

    private fun getDataFromIntent() =
        intent.getParcelableExtra(movieId) as Movie

    private fun observeMessages() =
        this.detailViewModel.toastLiveData.observe(this) { toast(it) }

    companion object {
        const val movieId = "movie"

        fun startActivityModel(activity: Activity?, movie: Movie) {
            activity?.startActivity<DetailActivity>(movieId to movie)
        }
    }
}
