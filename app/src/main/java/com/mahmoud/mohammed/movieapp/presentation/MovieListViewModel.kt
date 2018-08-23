package com.mahmoud.mohammed.movieapp.presentation

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.mahmoud.mohammed.movieapp.domain.MoviesRepository
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MovieListViewModel @Inject constructor(private val moviesRepository: MoviesRepository) : ViewModel() {
    var pagedListMovie = MutableLiveData<PagedList<Movie>>()
    private val compositeDisposable = CompositeDisposable()
    @SuppressLint("LogNotTimber", "CheckResult")
    fun getMovies() {

        compositeDisposable.add(moviesRepository.fetchOrGetMovies()
                .subscribe(
                        {
                            pagedListMovie.value = it
                        },
                        {
                            it.printStackTrace()
                        }))
    }
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}