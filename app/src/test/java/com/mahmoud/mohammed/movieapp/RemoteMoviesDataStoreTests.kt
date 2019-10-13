package com.mahmoud.mohammed.movieapp

/*

import com.mahmoud.mohammed.movieapp.data.api.Api
import com.mahmoud.mohammed.movieapp.data.api.MovieListResult
import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.data.mappers.DetailsDataMovieEntityMapper
import com.mahmoud.mohammed.movieapp.data.mappers.MovieDataEntityMapper
import com.mahmoud.mohammed.movieapp.data.repository.RemoteMoviesDataStore
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class RemoteMoviesDataStoreTests {
    private val movieDataMovieEntityMapper = MovieDataEntityMapper()
    private val detailsDataMovieEntityMapper = DetailsDataMovieEntityMapper()
    private lateinit var api: Api
    private lateinit var remoteMoviesDataStore: RemoteMoviesDataStore
    @Before
    fun before() {
        api = Mockito.mock(Api::class.java)
        remoteMoviesDataStore = RemoteMoviesDataStore(
                api
                , movieDataMovieEntityMapper
                , detailsDataMovieEntityMapper)

    }

    @Test
    fun whenRequestingPopularMovieListFromRemoteSourceReturnExpectedResult() {
        val movies = (0..5).map {
            MovieData(
                    id = it,
                    title = "Movie$it",
                    backdropPath = "",
                    originalLanguage = "",
                    posterPath = "",
                    originalTitle = "",
                    releaseDate = ""
            )
        }
        val movieListResult = MovieListResult()
        movieListResult.movies = movies
        movieListResult.page = 1
        Mockito.`when`(api.getPopularMovies()).thenReturn(Observable.just(movieListResult))
        remoteMoviesDataStore.getMovies().test()
                .assertValue { list -> list.size == 6 && list[0].title == "Movie0" }
                .assertComplete()
    }

}
*/
