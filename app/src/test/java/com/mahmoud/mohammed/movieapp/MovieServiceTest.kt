package com.mahmoud.mohammed.movieapp

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mahmoud.mohammed.movieapp.common.Endpoint
import com.mahmoud.mohammed.movieapp.data.remote.api.MovieListResult
import com.mahmoud.mohammed.movieapp.data.remote.api.MovieService
import junit.framework.Assert.assertEquals
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

const val  jsonResponseFileName="popular_movies_response.json"
class MovieServiceTestUsingMockWebServer {
    @get:Rule
    val mockWebServer = MockWebServer()

    private val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }
    private val movieService by lazy {
        retrofit.create(MovieService::class.java)
    }




    @Test
    fun TestMoviesServicePath() {
        mockWebServer.enqueue(
                MockResponse()
                        .setBody(MovieTestUtils.getJson(jsonResponseFileName))
                        .setResponseCode(200))
        val testObserver = movieService.getPopularMovies().test()
        testObserver.assertNoErrors()
        TestCase.assertEquals(Endpoint.DISCOVER,
                mockWebServer.takeRequest().path)
    }

}