package com.mahmoud.mohammed.movieapp.domain

import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.entities.Optional
import io.reactivex.Observable


interface MoviesRepository{
    suspend fun getMovies(): List<MovieData>

}