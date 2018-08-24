package com.mahmoud.mohammed.movieapp.domain

import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.entities.Optional
import io.reactivex.Observable


interface MoviesRepository{
    fun getMovies(): Observable<List<MovieEntity>>
    fun getMovie(movieId: Int): Observable<Optional<MovieEntity>>

}