package com.mahmoud.mohammed.movieapp.domain.usecases

import com.mahmoud.mohammed.movieapp.domain.MoviesCache
import com.mahmoud.mohammed.movieapp.domain.common.Transformer
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import java.lang.IllegalArgumentException


class CheckFavoriteStatus(transformer: Transformer<Boolean>,
                          private val moviesCache: MoviesCache) : UseCase<Boolean>(transformer) {

    companion object {
        private const val PARAM_MOVIE_ENTITY = "param:movieEntity"
    }

    override fun createObservable(data: Map<String, Any>?): Observable<Boolean> {
        val movieId = data?.get(PARAM_MOVIE_ENTITY)
        movieId?.let {
            return moviesCache.get(it as Int).flatMap { optionalMovieEntity ->
                return@flatMap Observable.just(optionalMovieEntity.hasValue())
            }
        } ?: return Observable.error({ IllegalArgumentException("MovieId must be provided.") })
    }

    fun check(movieId: Int): Observable<Boolean> {
        val data = HashMap<String, Int>()
        data[PARAM_MOVIE_ENTITY] = movieId
        return observable(data)
    }

}