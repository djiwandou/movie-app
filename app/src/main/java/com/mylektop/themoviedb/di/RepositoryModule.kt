package com.mylektop.themoviedb.di

import com.mylektop.themoviedb.repository.DiscoverRepository
import org.koin.dsl.module

/**
 * Created by MyLektop on 28/01/2020
 */
val repositoryModule = module {
    single { DiscoverRepository(get(), get()) }
}