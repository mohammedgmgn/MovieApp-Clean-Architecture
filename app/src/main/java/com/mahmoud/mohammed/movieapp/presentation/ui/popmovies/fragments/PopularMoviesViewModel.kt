package com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PopularMoviesViewModel
constructor(private val repository: Repository) : ViewModel() {


    internal var state: MutableLiveData<UiModel> = MutableLiveData()
    private val disposable = CompositeDisposable()


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun getPopularMovies() {
        disposable.add(repository.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    state.postValue(UiModel.Success(it))
                }, {
                    state.postValue(UiModel.Error(it.localizedMessage ?: "Something went wrong"))
                }))
    }


}