package com.mahmoud.mohammed.movieapp.data.repository

import androidx.paging.PagedList
import io.reactivex.Observable

interface MoviesRepositoryInterface {
    fun fetchOrGetMovies( ): Observable<PagedList<Movie>>
}