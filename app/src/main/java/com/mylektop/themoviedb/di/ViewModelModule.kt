package com.mylektop.themoviedb.di

import com.mylektop.themoviedb.view.ui.detail.DetailViewModel
import com.mylektop.themoviedb.view.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by MyLektop on 28/01/2020
 */
val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}