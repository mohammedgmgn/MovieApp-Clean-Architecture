package io.github.erikcaffrey.arch_components_paging_library.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mahmoud.mohammed.movieapp.data.model.Movie
import io.github.erikcaffrey.arch_components_paging_library.data.room.DATABASE.DATABASE_MOVIE
import io.github.erikcaffrey.arch_components_paging_library.data.room.DATABASE.DATABASE_MOVIE_VERSION

@Database(entities = [Movie::class], version = DATABASE_MOVIE_VERSION, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun movieDao(): MoviesDao

    companion object {

        @Volatile
        private var INSTANCE: MoviesDatabase? = null

        fun getInstance(context: Context): MoviesDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildMoviesDatabase(context).also { INSTANCE = it }
        }

        private fun buildMoviesDatabase(context: Context) = Room.databaseBuilder(context, MoviesDatabase::class.java, DATABASE_MOVIE).build()
    }
}
