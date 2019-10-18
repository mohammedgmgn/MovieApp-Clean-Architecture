package com.mahmoud.mohammed.movieapp.data.remote.api

import com.mahmoud.mohammed.movieapp.common.Endpoint
import com.mahmoud.mohammed.movieapp.data.remote.models.DetailsData
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET(Endpoint.VALID_EXPECTED_PATH)
    fun getPopularMovies(): Single<MovieListResult>


}