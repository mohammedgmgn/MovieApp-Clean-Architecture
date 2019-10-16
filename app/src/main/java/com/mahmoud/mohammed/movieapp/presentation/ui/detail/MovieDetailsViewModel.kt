package com.mahmoud.mohammed.movieapp.presentation.ui.detail

import androidx.lifecycle.MutableLiveData
import com.mahmoud.mohammed.movieapp.base.BaseViewModel
import com.mahmoud.mohammed.movieapp.data.local.MovieEntity

class MovieDetailsViewModel (
                             private val movieId: Int) : BaseViewModel() {
    lateinit var movieEntity: MovieEntity
    var viewState: MutableLiveData<MovieDetailsViewState> = MutableLiveData()
    var favoriteState: MutableLiveData<Boolean> = MutableLiveData()

}
