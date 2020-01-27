package com.mylektop.themoviedb

import android.app.Application
import com.mylektop.themoviedb.di.networkModule
import com.mylektop.themoviedb.di.persistenceModule
import com.mylektop.themoviedb.di.repositoryModule
import com.mylektop.themoviedb.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@MainApplication)
            // use modules
            modules(networkModule)
            modules(persistenceModule)
            modules(repositoryModule)
            modules(viewModelModule)
        }
    }
}
