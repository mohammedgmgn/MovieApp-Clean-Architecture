package com.mahmoud.mohammed.movieapp.data.repository

import android.webkit.ValueCallback
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.mahmoud.mohammed.movieapp.data.model.Movie
import com.mahmoud.mohammed.movieapp.data.remote.MovieRemoteDataSourceDownloader
import io.github.erikcaffrey.arch_components_paging_library.data.room.DATABASE
import io.github.erikcaffrey.arch_components_paging_library.data.room.MoviesLocalDataSource
import io.reactivex.Observable

class MoviesRepository(private val moviesRemoteDataSource: MovieRemoteDataSourceDownloader,
                       private val locaDataSource: MoviesLocalDataSource,
                       private val callBack: ValueCallback<Boolean>) {
    fun fetchOrGetMovies(): Observable<PagedList<Movie>> = RxPagedListBuilder(locaDataSource.getMovies(),
            DATABASE.PAGE_SIZE)
            .setBoundaryCallback(PageListMovieBoundaryCallback(moviesRemoteDataSource, locaDataSource))
            .buildObservable().doOnComplete {
                callBack.onReceiveValue(true)
            }
            .doOnError {
                callBack.onReceiveValue(false)
            }

}