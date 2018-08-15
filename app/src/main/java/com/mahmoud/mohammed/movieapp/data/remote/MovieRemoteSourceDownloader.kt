package com.mahmoud.mohammed.movieapp.data.remote

import com.mahmoud.mohammed.movieapp.data.model.Movie
import io.reactivex.Single

class MovieRemoteSourceDownloader(private val moviesService: MoviesService) : MovieRemoteSourceInterface {
    override fun getMovieList(page: Int): Single<List<Movie>>
    = moviesService.getMovieList(page)
}