package com.mahmoud.mohammed.movieapp.presentation.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mahmoud.mohammed.movieapp.domain.Mapper
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.usecases.CheckFavoriteStatus
import com.mahmoud.mohammed.movieapp.domain.usecases.GetMovieDetails
import com.mahmoud.mohammed.movieapp.domain.usecases.RemoveFavoriteMovie
import com.mahmoud.mohammed.movieapp.domain.usecases.SaveFavoriteMovie
import com.mahmoud.mohammed.movieapp.presentation.entities.Movie
import io.reactivex.ObservableTransformer

class MovieDetailsVMFactory(
        private val getMovieDetails: GetMovieDetails,
        private val saveFavoriteMovie: SaveFavoriteMovie,
        private val removeFavoriteMovie: RemoveFavoriteMovie,
        private val checkFavoriteStatus: CheckFavoriteStatus,
        private val mapper: Mapper<MovieEntity, Movie>) : ViewModelProvider.Factory {

    var movieId: Int = -1

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailsViewModel(
                getMovieDetails,
                saveFavoriteMovie,
                removeFavoriteMovie,
                checkFavoriteStatus,
                mapper,
                movieId) as T
    }

}