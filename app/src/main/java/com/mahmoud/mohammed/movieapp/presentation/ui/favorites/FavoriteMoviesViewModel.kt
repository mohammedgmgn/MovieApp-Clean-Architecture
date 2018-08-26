package com.mahmoud.mohammed.movieapp.presentation.ui.favorites

import com.mahmoud.mohammed.movieapp.base.BaseViewModel
import com.mahmoud.mohammed.movieapp.domain.Mapper
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.usecases.GetFavoriteMovies
import com.mahmoud.mohammed.movieapp.presentation.entities.Movie

class FavoriteMoviesViewModel (private val getFavoriteMovies: GetFavoriteMovies,
                               private val movieEntityMovieMapper: Mapper<MovieEntity, Movie>) : BaseViewModel() {
}