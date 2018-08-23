package com.mahmoud.mohammed.movieapp.domain

import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.entities.Optional

import io.reactivex.Observable

interface MoviesDataStore {
    fun getMovieById(movieId: Int): Observable<Optional<MovieEntity>>
    fun getMovies(): Observable<List<MovieEntity>>

}
