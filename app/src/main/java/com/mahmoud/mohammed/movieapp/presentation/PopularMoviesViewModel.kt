package com.mahmoud.mohammed.movieapp.presentation

import androidx.lifecycle.ViewModel
import com.mahmoud.mohammed.movieapp.base.BaseViewModel
import com.mahmoud.mohammed.movieapp.domain.Mapper
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.usecases.GetPopularMovies
import com.mahmoud.mohammed.movieapp.presentation.entities.Movie
import javax.inject.Inject

class PopularMoviesViewModel
@Inject constructor(
        private val getPopularMovies: GetPopularMovies,
        private val movieEntityMovieMapper: Mapper<MovieEntity, Movie>) : BaseViewModel() {

}