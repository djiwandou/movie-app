package com.mylektop.themoviedb.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mylektop.themoviedb.models.entity.Movie

/**
 * Created by MyLektop on 28/01/2020
 */
@Database(entities = [(Movie::class)], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}