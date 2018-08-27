package com.mahmoud.mohammed.movieapp

import com.mahmoud.mohammed.movieapp.data.api.Api
import com.mahmoud.mohammed.movieapp.data.api.MovieListResult
import com.mahmoud.mohammed.movieapp.data.mappers.DetailsDataMovieEntityMapper
import com.mahmoud.mohammed.movieapp.data.mappers.MovieDataEntityMapper
import com.mahmoud.mohammed.movieapp.data.repository.MoviesRepositoryImpl
import com.mahmoud.mohammed.movieapp.domain.MoviesRepository
import com.mahmoud.mohammed.movieapp.domain.common.DomainTestUtils.Companion.generateMovieEntityList
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class MovieRepositoryImplTests {

    private val movieDataMapper = MovieDataEntityMapper()
    private val detailsDataMapper = DetailsDataMovieEntityMapper()
    private lateinit var api: Api
    private lateinit var movieCache: TestMoviesCache
    private lateinit var movieRepository: MoviesRepository

    @Before
    fun before() {
        api = mock(Api::class.java)
        movieCache = TestMoviesCache()
        movieRepository = MoviesRepositoryImpl(api, movieCache, movieDataMapper, detailsDataMapper)
    }

    @Test
    fun testWhenCacheIsNotEmptyGetMoviesReturnsCachedMovies() {

        movieCache.saveAll(generateMovieEntityList())
        movieRepository.getMovies().test()
                .assertComplete()
                .assertValue { movies -> movies.size == 5 }

        verifyZeroInteractions(api)
    }

    @Test
    fun testWhenCacheIsEmptyGetMoviesReturnsMoviesFromApi() {
        val movieListResult = MovieListResult()
        movieListResult.movies = TestsUtils.generateMovieDataList()
        `when`(api.getPopularMovies()).thenReturn(Observable.just(movieListResult))
        movieRepository.getMovies().test()
                .assertComplete()
                .assertValue { movies -> movies.size == 5 }
    }


    @Test
    fun testGetMovieByIdReturnedApiMovie() {
        val detailsData = TestsUtils.generateDetailsData(100)

        `when`(api.getMovieDetails(100)).thenReturn(Observable.just(detailsData))
        movieRepository.getMovie(100).test()
                .assertComplete()
                .assertValue { it.hasValue() && it.value == detailsDataMapper.mapFrom(detailsData) }
    }
}