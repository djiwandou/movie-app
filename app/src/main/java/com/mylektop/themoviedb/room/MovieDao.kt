package com.mylektop.themoviedb.room

import androidx.room.*
import com.mylektop.themoviedb.models.entity.Movie

/**
 * Created by MyLektop on 28/01/2020
 */
@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovieList(movies: List<Movie>)

    @Update
    fun updateMovie(movie: Movie)

    @Query("SELECT * FROM movie WHERE id = :id_")
    fun getMovie(id_: Int): Movie

    @Query("SELECT * FROM movie WHERE page = :page_")
    fun getMovieList(page_: Int): List<Movie>
}