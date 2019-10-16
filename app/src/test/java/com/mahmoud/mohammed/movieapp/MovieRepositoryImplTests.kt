package com.mahmoud.mohammed.movieapp

import com.google.gson.Gson
import com.mahmoud.mohammed.movieapp.data.RepositoryImpl
import com.mahmoud.mohammed.movieapp.data.remote.api.MovieListResult
import com.mahmoud.mohammed.movieapp.data.remote.api.MovieService
import io.reactivex.Single
import org.junit.Test

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever

class MovieRepositoryImplTests {

    private val movieService: MovieService = mock()
    private val repository = RepositoryImpl(movieService)

    @Test
    fun getTestMovieResponse() {
        val gson = Gson()
        val testModel = gson.fromJson(MovieTestUtils.getJson(jsonResponseFileName), MovieListResult::class.java)
        whenever(movieService.getPopularMovies())
                .thenReturn(Single.just(testModel))
        val testObserver = repository.getMovies().test()
        testObserver.assertValue(testModel)
    }


}
