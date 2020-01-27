package com.mylektop.themoviedb.room

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by MyLektop on 28/01/2020
 */
@Database(entities = [], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
}