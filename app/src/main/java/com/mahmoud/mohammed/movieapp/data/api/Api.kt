package com.mahmoud.mohammed.movieapp.data.api

import com.mahmoud.mohammed.movieapp.data.entities.DetailsData
import io.reactivex.Observable
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("movie/{id}?append_to_response=videos,reviews")
    fun getMovieDetails(@Path("id") movieId: Int): Observable<DetailsData>

    @GET("movie/popular") ///movie/now_playing
    fun getPopularMovies(): Deferred<MovieListResult>

}