package com.mahmoud.mohammed.movieapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mahmoud.mohammed.movieapp.data.db.DATABASE.DATABASE_MOVIE_VERSION
import com.mahmoud.mohammed.movieapp.data.entities.MovieData

@Database(entities = arrayOf(MovieData::class), version = DATABASE_MOVIE_VERSION)
abstract class MoviesDatabase  : RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
}
