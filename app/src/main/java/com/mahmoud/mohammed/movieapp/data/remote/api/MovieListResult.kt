package com.mahmoud.mohammed.movieapp.data.remote.api

import com.google.gson.annotations.SerializedName
import com.mahmoud.mohammed.movieapp.data.remote.models.MovieData

class MovieListResult(

        @SerializedName("page") val page: Int,
        @SerializedName("results")
        val movies: List<MovieData>

)