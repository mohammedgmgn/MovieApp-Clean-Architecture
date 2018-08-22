package com.mahmoud.mohammed.movieapp.data.repository

import android.annotation.SuppressLint
import android.util.Log
import android.webkit.ValueCallback
import androidx.paging.PagedList
import com.mahmoud.mohammed.movieapp.data.model.Movie
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PageListMovieBoundaryCallback @Inject constructor (private val remoteDataRepository: RemoteDataRepository,
                                     private val locaDataSource: MoviesLocalDataSource) :
        PagedList.BoundaryCallback<Movie>() {
    private var isRequestRunning = false
    private var requestedPage = 1
    private var isMovieListArrived = false

    override fun onZeroItemsLoaded() {
        Log.i(TAG, "onZeroItemsLoaded")
        fetchAndStoreMovies()
    }

    override fun onItemAtEndLoaded(itemAtEnd: Movie) {
        Log.i(TAG, "onItemAtEndLoaded")
        fetchAndStoreMovies()

    }

    companion object {
        private const val TAG: String = "PageListMovieBoundary "
    }

    @SuppressLint("CheckResult")
    private fun fetchAndStoreMovies() {
        if (isRequestRunning) return
        isRequestRunning = true
        remoteDataRepository.getMovieList(requestedPage,callBack = ValueCallback {
                    isMovieListArrived=it
                })
                .map {
                    movieApiList ->
                    movieApiList.map {
                        it.toMovieEntity()
                    }
                }
                .doOnSuccess {
                    listMovie ->
                    if (listMovie.isNotEmpty()) {
                        locaDataSource.storeMovies(listMovie)
                        Log.i(TAG, "Inserted: ${listMovie.size}")
                    } else {
                        Log.i(TAG, "No Inserted")
                    }
                    requestedPage++
                }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .toCompletable()
                .doFinally { isRequestRunning = false }
                .subscribe({ Log.i(TAG, "Movies Completed") }, { it.printStackTrace() })

    }

}