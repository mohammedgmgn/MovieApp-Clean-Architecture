package com.mahmoud.mohammed.movieapp

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mahmoud.mohammed.movieapp.common.Endpoint
import com.mahmoud.mohammed.movieapp.data.remote.api.MovieListResult
import com.mahmoud.mohammed.movieapp.data.remote.api.MovieService
import junit.framework.TestCase
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val jsonResponseFileName = "popular_movies_response.json"

class MovieServiceTestUsingMockWebServer {
    @get:Rule
    val mockWebServer = MockWebServer()

    private val retrofit by lazy {
        Retrofit.Builder()
                //1
                .baseUrl(mockWebServer.url("/"))
                //2
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //3
                .addConverterFactory(GsonConverterFactory.create())
                //4
                .build()

    }
    private val movieService by lazy {
        retrofit.create(MovieService::class.java)
    }


    @Test
    fun testPopularMovies() {
        // 1
        mockWebServer.enqueue(
                // 2
                MockResponse()
                        // 3
                        .setBody(MovieTestUtils.getJson(jsonResponseFileName))
                        // 4
                        .setResponseCode(200)

        )
        //1
        val testObserver = movieService.getPopularMovies().test()
        //2
        TestCase.assertEquals(testObserver.values()[0].movies, MovieTestUtils.getMovieTestObject().movies)
    }

    @Test
    fun testMoviesServicePath() {
        mockWebServer.enqueue(
                MockResponse()
                        .setBody(MovieTestUtils.getJson(jsonResponseFileName))
                        .setResponseCode(200))

        val testObserver = movieService.getPopularMovies().test()
        testObserver.assertNoErrors()
        TestCase.assertEquals(Endpoint.DISCOVER,mockWebServer.takeRequest().path)
    }

}