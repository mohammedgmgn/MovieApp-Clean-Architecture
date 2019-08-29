package com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments

import android.provider.Contacts
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoud.mohammed.movieapp.base.BaseViewModel
import com.mahmoud.mohammed.movieapp.common.SingleLiveEvent
import com.mahmoud.mohammed.movieapp.domain.Mapper
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.usecases.GetPopularMovies
import com.mahmoud.mohammed.movieapp.presentation.entities.Movie
import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope.coroutineContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class PopularMoviesViewModel
constructor(
        private val getPopularMovies: GetPopularMovies) : ViewModel() ,CoroutineScope{

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    var viewState: MutableLiveData<PopularMoviesViewState> = MutableLiveData()
    var errorState: SingleLiveEvent<Throwable?> = SingleLiveEvent()


    init {
        viewState.value = PopularMoviesViewState()
    }
    override fun onCleared() {
        job.cancel()
    }

    fun getPopularMovies() {

        viewModelScope.launch(Dispatchers.Main) {
            try {
                val movies = getPopularMovies.getMovies()
                val newState = viewState.value?.copy(showLoading = false, movies = movies)
                viewState.value = newState

            } catch (e: Exception) {
                Log.v("MoviesException",e.message)
                //errorState.value = e

            }
        }



    }


}