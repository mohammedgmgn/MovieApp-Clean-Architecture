package com.mahmoud.mohammed.movieapp.data

import com.mahmoud.mohammed.movieapp.BuildConfig
import com.mahmoud.mohammed.movieapp.Movie
import io.reactivex.Single
import retrofit2.http.GET

interface MoviesService {
    @GET("/3/discover/movie?api_key="+ BuildConfig.THE_MOVIE_API_KEY)
    fun movieList(): Single<List<Movie>>
}