package com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments

import androidx.lifecycle.MutableLiveData
import com.mahmoud.mohammed.movieapp.base.BaseViewModel
import com.mahmoud.mohammed.movieapp.data.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PopularMoviesViewModel
constructor(private val repository: Repository) : BaseViewModel() {


    internal var state: MutableLiveData<UiModel> = MutableLiveData()
    fun getPopularMovies() {
        addDisposable(repository.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    state.postValue(UiModel.Success(it))
                }, {
                    state.postValue(UiModel.Error(it.localizedMessage ?: "Something went wrong"))
                }))
    }


}