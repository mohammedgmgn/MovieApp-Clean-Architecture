package com.mahmoud.mohammed.movieapp.data.remote

import com.mahmoud.mohammed.movieapp.data.model.Movie
import io.reactivex.Single

interface MovieRemoteSourceInterface {
    fun getMovieList(page:Int) : Single<List<Movie>>
}