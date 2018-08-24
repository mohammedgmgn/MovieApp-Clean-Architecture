package com.mahmoud.mohammed.movieapp.common

import com.mahmoud.mohammed.movieapp.BuildConfig
import com.mahmoud.mohammed.movieapp.data.api.MovieListResult
import com.mahmoud.mohammed.movieapp.data.entities.DetailsData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


object Endpoint {
    const val DISCOVER = "discover/movie"
    const   val THE_MOVIE_URL = "https://api.themoviedb.org/3/"
    const val IMAGES_URL = "https://image.tmdb.org/t/p/w185_and_h278_bestv2"

}

object Query {
    const val API_KEY = "api_key"
    const val PAGE = "page"
    const val SORT_BY = "sort_by"
    const val LANGUAGE = "language"
    const val INCLUDE_ADULT = "include_adult"

    const val SORT_BY_DEFAULT = "popularity.desc"
    const val LANGUAGE_DEFAULT = "en-US"
    const val INCLUDE_ADULT_DEFAULT = false

    // Please Use the key value like professional developer, avoid bad usages!!
    // (I shouldn't expose it but it is used for didactic purpose)
    const val API_KEY_VALUE = BuildConfig.THE_MOVIE_API_KEY
}
