package com.mahmoud.mohammed.movieapp.data.api

import com.google.gson.annotations.SerializedName
import com.mahmoud.mohammed.movieapp.data.entities.MovieData

class MovieListResult {

    var page: Int = 0
    @SerializedName("results")
    lateinit var movies: List<MovieData>
}