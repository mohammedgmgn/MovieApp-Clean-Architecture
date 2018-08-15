package com.mahmoud.mohammed.movieapp.data.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.paging.PagedList
import com.mahmoud.mohammed.movieapp.data.model.Movie
import com.mahmoud.mohammed.movieapp.data.remote.MovieRemoteDataSourceDownloader
import com.mahmoud.mohammed.movieapp.data.remote.toMovieEntity
import io.github.erikcaffrey.arch_components_paging_library.data.room.MoviesLocalDataSource
import io.reactivex.schedulers.Schedulers

class MoviesRepository(private val moviesRemoteDataSource: MovieRemoteDataSourceDownloader,
                       private val locaDataSource: MoviesLocalDataSource) :
        PagedList.BoundaryCallback<Movie>() {
    private var isRequestRunning = false
    private var requestedPage = 1

    override fun onZeroItemsLoaded() {
        Log.i(TAG, "onZeroItemsLoaded")

    }

    override fun onItemAtEndLoaded(itemAtEnd: Movie) {
        Log.i(TAG, "onItemAtEndLoaded")

    }

    companion object {
        private const val TAG: String = "PageListMovieBoundary "
    }

    @SuppressLint("CheckResult")
    private fun fetchAndStoreMovies() {
        if (isRequestRunning) return
        isRequestRunning = true
        moviesRemoteDataSource
                .getMovieList(requestedPage)
                .map { movieApiList ->
                    movieApiList.map {
                        it.toMovieEntity()
                    }
                }
                .doOnSuccess { listMovie ->
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