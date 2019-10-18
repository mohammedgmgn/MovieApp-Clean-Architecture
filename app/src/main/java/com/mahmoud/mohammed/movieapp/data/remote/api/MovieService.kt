

package com.mahmoud.mohammed.movieapp.data.remote.api

import io.reactivex.Single
import retrofit2.http.GET

interface MovieService {

    @GET(Endpoint.VALID_EXPECTED_PATH)
    fun getPopularMovies(): Single<MovieListResult>


}

