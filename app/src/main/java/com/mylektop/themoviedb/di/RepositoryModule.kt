package com.mylektop.themoviedb.di

import com.mylektop.themoviedb.repository.MovieRepository
import org.koin.dsl.module

/**
 * Created by MyLektop on 28/01/2020
 */
val repositoryModule = module {
    single { MovieRepository(get(), get()) }
}