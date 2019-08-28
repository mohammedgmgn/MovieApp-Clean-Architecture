package com.mahmoud.mohammed.movieapp.data.repository

import android.util.Log
import com.mahmoud.mohammed.movieapp.data.api.Api
import com.mahmoud.mohammed.movieapp.data.api.MovieListResult
import com.mahmoud.mohammed.movieapp.data.entities.DetailsData
import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.domain.Mapper
import com.mahmoud.mohammed.movieapp.domain.MoviesDataStore
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.entities.Optional
import com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments.PopularMoviesViewState
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class RemoteMoviesDataStore(private val api: Api) :
        MoviesDataStore {
    override suspend fun getMovies(): List<MovieData> {

        val movies=api.getPopularMovies().await().movies
        return movies
    }
}


