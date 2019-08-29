package com.mahmoud.mohammed.movieapp.presentation.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mahmoud.mohammed.movieapp.data.entities.MovieData

class SharedViewModel : ViewModel() {
    val data = MutableLiveData<MovieData>()

    fun data(item: MovieData) {
        data.value = item
    }
}
