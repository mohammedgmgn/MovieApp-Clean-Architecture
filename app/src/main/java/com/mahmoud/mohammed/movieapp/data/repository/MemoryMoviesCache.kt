package com.mahmoud.mohammed.movieapp.data.repository

import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.domain.MoviesCache
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.entities.Optional
import io.reactivex.Observable

class MemoryMoviesCache : MoviesCache {
    private val movies: LinkedHashMap<Int, MovieData> = LinkedHashMap()

    override fun save(movieEntity: MovieData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun remove(movieEntity: MovieData) {
        movies.remove(movieEntity.id)
    }

    override fun saveAll(movieEntities: List<MovieData>) {
        movieEntities.forEach { movieEntity -> this.movies[movieEntity.id] = movieEntity }
    }
    override fun isEmpty(): Boolean {
        return movies.isEmpty()
    }
    override fun clear() {
        movies.clear()
    }


    override suspend fun getAll(): List<MovieData> {
        return movies.values.toList()
    }

    override fun get(movieId: Int): Optional<MovieData> {
        return  Optional.of(movies[movieId])
    }


}
