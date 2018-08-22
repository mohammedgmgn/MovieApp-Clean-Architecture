package com.mahmoud.mohammed.movieapp.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class BaseViewModel : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    private fun clearDisposables() {
        compositeDisposable.clear()
    }

    override fun onCleared() {
        clearDisposables()
    }
}