package com.mahmoud.mohammed.movieapp.data.remote

import com.mahmoud.mohammed.movieapp.data.model.Movie
import io.reactivex.Single

class MovieRemoteDataSourceDownloader(private val moviesService: MoviesService) : MovieRemoteSourceInterface {
    override fun getMovieList(page: Int): Single<List<MovieApi>>
    = moviesService.getMovieList(page)

}