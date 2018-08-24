package com.mahmoud.mohammed.movieapp.data.repository

import com.mahmoud.mohammed.movieapp.data.api.Api
import com.mahmoud.mohammed.movieapp.data.entities.DetailsData
import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.domain.Mapper
import com.mahmoud.mohammed.movieapp.domain.MoviesDataStore
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.entities.Optional
import io.reactivex.Observable

class RemoteMoviesDataStore (private val api: Api,
                             private val movieDataMapper: Mapper<MovieData, MovieEntity>,
                             private val detailedDataMapper: Mapper<DetailsData, MovieEntity>):
        MoviesDataStore {
    override fun getMovieById(movieId: Int): Observable<Optional<MovieEntity>> {
        return api.getMovieDetails(movieId).flatMap { detailedData ->
            Observable.just(Optional.of(detailedDataMapper.mapFrom(detailedData)))
        }    }

    override fun getMovies(): Observable<List<MovieEntity>> {
        return api.getPopularMovies().map { results->
            results.movies.map { movieDataMapper.mapFrom(it) }
        }
    }
}