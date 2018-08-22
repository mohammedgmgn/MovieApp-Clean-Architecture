package com.mahmoud.mohammed.movieapp.data.repository

import android.webkit.ValueCallback
import androidx.paging.PagedList
import com.mahmoud.mohammed.movieapp.data.model.Movie
import io.reactivex.Observable

interface MoviesRepositoryInterface {
    fun fetchOrGetMovies( ): Observable<PagedList<Movie>>
}