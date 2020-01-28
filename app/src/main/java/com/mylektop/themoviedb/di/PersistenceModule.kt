package com.mylektop.themoviedb.di

import androidx.room.Room
import com.mylektop.themoviedb.room.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Created by MyLektop on 28/01/2020
 */
val persistenceModule = module {
    single {
        Room
            .databaseBuilder(androidApplication(), AppDatabase::class.java, "movie_app.db")
            .allowMainThreadQueries()
            .build()
    }

    single { get<AppDatabase>().movieDao() }
}