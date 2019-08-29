package com.mahmoud.mohammed.movieapp.data.repository

import com.mahmoud.mohammed.movieapp.data.api.Api
import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.domain.MoviesCache
import com.mahmoud.mohammed.movieapp.domain.MoviesDataStore
import com.mahmoud.mohammed.movieapp.domain.MoviesRepository

class MoviesRepositoryImpl(private val api: Api, private val cache: MoviesCache
) : MoviesRepository {

    private val memoryDataStore: MoviesDataStore
    private val remoteDataStore: MoviesDataStore

    init {
        memoryDataStore = CachedMoviesDataStore(cache)
        remoteDataStore = RemoteMoviesDataStore(api)
    }

    override suspend fun getMovies(): List<MovieData> {
        if (!cache.isEmpty()) {
            return memoryDataStore.getMovies()
        } else {
            val result = remoteDataStore.getMovies()
            cache.saveAll(result)
            return result
        }
    }


}