package com.mahmoud.mohammed.movieapp.common

import com.mahmoud.mohammed.movieapp.BuildConfig


object Endpoint {
    const val API_KEY_VALUE = BuildConfig.THE_MOVIE_API_KEY

    const   val THE_MOVIE_URL = "https://api.themoviedb.org/3/"
    const val IMAGES_URL = "https://image.tmdb.org/t/p/w185_and_h278_bestv2"
    const val BASE_URL = "https://api.themoviedb.org"

    const val DISCOVER = "/3/discover/movie?api_key=$API_KEY_VALUE"



}

