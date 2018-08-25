package com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments

import com.mahmoud.mohammed.movieapp.presentation.entities.Movie


data class PopularMoviesViewState(
        var showLoading: Boolean = true,
        var movies: List<Movie>? = null
)
