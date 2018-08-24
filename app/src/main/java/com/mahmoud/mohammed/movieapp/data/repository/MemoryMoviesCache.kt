package com.mahmoud.mohammed.movieapp.data.repository

import com.mahmoud.mohammed.movieapp.domain.MoviesCache
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.entities.Optional
import io.reactivex.Observable

class MemoryMoviesCache : MoviesCache {

    private val movies: LinkedHashMap<Int, MovieEntity> = LinkedHashMap()

    override fun isEmpty(): Boolean {
        return movies.isEmpty()
    }

    override fun remove(movieEntity: MovieEntity) {
        movies.remove(movieEntity.id)
    }

    override fun clear() {
        movies.clear()
    }

    override fun save(movieEntity: MovieEntity) {
        movies[movieEntity.id] = movieEntity
    }

    override fun saveAll(movieEntities: List<MovieEntity>) {
        movieEntities.forEach { movieEntity -> this.movies[movieEntity.id] = movieEntity }
    }

    override fun getAll(): Observable<List<MovieEntity>> {
        return Observable.just(movies.values.toList())
    }

    override fun get(movieId: Int): Observable<Optional<MovieEntity>> {
        return Observable.just(Optional.of(movies[movieId]))
    }

    override fun search(query: String): Observable<List<MovieEntity>> {
        return Observable.fromCallable {
            movies.values.filter {
                it.title.contains(query) || it.originalTitle.contains(query)
            }
        }
    }
}

