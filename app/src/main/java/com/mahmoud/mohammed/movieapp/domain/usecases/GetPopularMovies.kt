package com.mahmoud.mohammed.movieapp.domain.usecases

import com.mahmoud.mohammed.movieapp.domain.MoviesRepository
import com.mahmoud.mohammed.movieapp.domain.common.Transformer
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import io.reactivex.Observable
import javax.inject.Inject

open class GetPopularMovies  constructor(transformer: Transformer<List<MovieEntity>>,
                                                private val moviesRepository: MoviesRepository) : UseCase<List<MovieEntity>>(transformer) {
    override fun createObservable(data: Map<String, Any>?): Observable<List<MovieEntity>> {
        return moviesRepository.getMovies()
    }

}