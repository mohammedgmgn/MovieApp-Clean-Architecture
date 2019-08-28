package com.mahmoud.mohammed.movieapp.domain.usecases

import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.domain.MoviesRepository

class GetPopularMovies constructor(private val moviesRepository: MoviesRepository) {

    suspend fun getMovies(): List<MovieData> {
        return moviesRepository.getMovies()
    }
}
