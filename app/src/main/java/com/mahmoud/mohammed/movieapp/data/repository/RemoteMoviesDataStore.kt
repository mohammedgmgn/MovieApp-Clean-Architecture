package com.mahmoud.mohammed.movieapp.data.repository

import com.mahmoud.mohammed.movieapp.data.api.Api
import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.domain.MoviesDataStore

class RemoteMoviesDataStore(private val api: Api) :
        MoviesDataStore {
    override suspend fun getMovies(): List<MovieData> {
        val movies = api.getPopularMovies().await().movies
        return movies
    }
}


