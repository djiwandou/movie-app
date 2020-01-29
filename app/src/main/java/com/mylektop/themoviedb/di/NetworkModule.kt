package com.mylektop.themoviedb.di

import com.mylektop.themoviedb.api.RequestInterceptor
import com.mylektop.themoviedb.api.client.MovieClient
import com.mylektop.themoviedb.api.service.MovieService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by MyLektop on 28/01/2020
 */
val networkModule = module {

    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addInterceptor(interceptor)
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(MovieService::class.java)
    }

    single { MovieClient(get()) }
}