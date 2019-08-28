package com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments

import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.presentation.entities.Movie


data class PopularMoviesViewState(
        var showLoading: Boolean = true,
        var movies: List<MovieData>? = null
)
