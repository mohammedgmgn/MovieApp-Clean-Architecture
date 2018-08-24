package com.mahmoud.mohammed.movieapp.data.repository

import com.mahmoud.mohammed.movieapp.data.api.Api
import com.mahmoud.mohammed.movieapp.data.entities.DetailsData
import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.domain.Mapper
import com.mahmoud.mohammed.movieapp.domain.MoviesCache
import com.mahmoud.mohammed.movieapp.domain.MoviesDataStore
import com.mahmoud.mohammed.movieapp.domain.MoviesRepository
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.entities.Optional
import io.reactivex.Observable

class MoviesRepositoryImpl (api: Api,
                            private val cache: MoviesCache,
                            movieDataMapper: Mapper<MovieData, MovieEntity>,
                            detailedDataMapper: Mapper<DetailsData, MovieEntity>) : MoviesRepository {

    private val memoryDataStore: MoviesDataStore
    private val remoteDataStore: MoviesDataStore

    init {
        memoryDataStore = CachedMoviesDataStore(cache)
        remoteDataStore = RemoteMoviesDataStore(api, movieDataMapper, detailedDataMapper)
    }

    override fun getMovies(): Observable<List<MovieEntity>> {
        return if (!cache.isEmpty()) {
            return memoryDataStore.getMovies()
        } else {
            remoteDataStore.getMovies().doOnNext { cache.saveAll(it) }
        }
    }


    override fun getMovie(movieId: Int): Observable<Optional<MovieEntity>> {
        return remoteDataStore.getMovieById(movieId)
    }

}