package com.mahmoud.mohammed.movieapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mahmoud.mohammed.movieapp.data.model.Movie
import com.mahmoud.mohammed.movieapp.data.db.DATABASE.DATABASE_MOVIE
import com.mahmoud.mohammed.movieapp.data.db.DATABASE.DATABASE_MOVIE_VERSION
import com.mahmoud.mohammed.movieapp.data.entities.MovieData

@Database(entities = arrayOf(MovieData::class), version = 1)
abstract class MoviesDatabase  : RoomDatabase() {
    abstract fun getMoviesDao(): MoviesDao
}
