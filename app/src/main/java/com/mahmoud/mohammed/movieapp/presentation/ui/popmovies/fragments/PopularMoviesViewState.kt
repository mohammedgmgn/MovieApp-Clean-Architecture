package com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments

import com.mahmoud.mohammed.movieapp.data.remote.models.MovieData


data class PopularMoviesViewState(
        var showLoading: Boolean = true,
        var movies: List<MovieData>? = null
)
data class ErrorViewState(
        var showLoading: String = ""
)
