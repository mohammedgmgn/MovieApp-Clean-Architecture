package com.mahmoud.mohammed.movieapp.data.repository

import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.mahmoud.mohammed.movieapp.data.model.Movie
import com.mahmoud.mohammed.movieapp.data.db.DATABASE
import io.reactivex.Observable

class MoviesRepository(private val moviesRemoteDataSource: RemoteDataRepository,
                                           private val locaDataSource: MoviesLocalDataSource)
    :MoviesRepositoryInterface {

   override fun fetchOrGetMovies(): Observable<PagedList<Movie>>
           = RxPagedListBuilder(locaDataSource.getMovies(),
            DATABASE.PAGE_SIZE)
            .setBoundaryCallback(PageListMovieBoundaryCallback(moviesRemoteDataSource, locaDataSource))
            .buildObservable()

}