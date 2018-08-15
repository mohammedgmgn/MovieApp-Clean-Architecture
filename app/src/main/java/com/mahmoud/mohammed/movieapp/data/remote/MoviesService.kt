package com.mahmoud.mohammed.movieapp.data.remote

import com.mahmoud.mohammed.movieapp.data.model.Movie
import com.mahmoud.mohammed.movieapp.common.Endpoint.DISCOVER
import com.mahmoud.mohammed.movieapp.common.Query.API_KEY
import com.mahmoud.mohammed.movieapp.common.Query.API_KEY_VALUE
import com.mahmoud.mohammed.movieapp.common.Query.INCLUDE_ADULT
import com.mahmoud.mohammed.movieapp.common.Query.INCLUDE_ADULT_DEFAULT
import com.mahmoud.mohammed.movieapp.common.Query.LANGUAGE
import com.mahmoud.mohammed.movieapp.common.Query.LANGUAGE_DEFAULT
import com.mahmoud.mohammed.movieapp.common.Query.PAGE
import com.mahmoud.mohammed.movieapp.common.Query.SORT_BY
import com.mahmoud.mohammed.movieapp.common.Query.SORT_BY_DEFAULT
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {
    @GET(DISCOVER)
    fun getMovieList(@Query(PAGE) page: Int,
                     @Query(SORT_BY) sortBy: String = SORT_BY_DEFAULT,
                     @Query(LANGUAGE) language: String = LANGUAGE_DEFAULT,
                     @Query(INCLUDE_ADULT) includeAdult: Boolean = INCLUDE_ADULT_DEFAULT,
                     @Query(API_KEY) apiKey: String = API_KEY_VALUE): Single<List<Movie>>

}