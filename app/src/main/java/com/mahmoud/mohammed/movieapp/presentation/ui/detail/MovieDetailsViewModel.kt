package com.mahmoud.mohammed.movieapp.presentation.ui.detail

import androidx.lifecycle.MutableLiveData
import com.mahmoud.mohammed.movieapp.base.BaseViewModel
import com.mahmoud.mohammed.movieapp.common.SingleLiveEvent
import com.mahmoud.mohammed.movieapp.domain.Mapper
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.presentation.entities.Movie
import io.reactivex.Observable
import io.reactivex.functions.BiFunction

class MovieDetailsViewModel (
                             private val mapper: Mapper<MovieEntity, Movie>,
                             private val movieId: Int) : BaseViewModel() {
    lateinit var movieEntity: MovieEntity
    var viewState: MutableLiveData<MovieDetailsViewState> = MutableLiveData()
    var favoriteState: MutableLiveData<Boolean> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable> = SingleLiveEvent()

}
