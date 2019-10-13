package com.mahmoud.mohammed.movieapp

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mahmoud.mohammed.movieapp.data.api.MovieService
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val id = "6"
private const val joke = "How does a train eat? It goes chew, chew"
private const val testJson = """{ "id": $id, "joke": "$joke" }"""

class MovieServiceTestUsingMockWebServer {
    @get:Rule
    val mockWebServer = MockWebServer()

    private val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

    }
    private val movieService by lazy {
        retrofit.create(MovieService::class.java)
    }
//        val movies = api.getPopularMovies().await().movies


    @Test
    fun getMovies() {
        mockWebServer.enqueue(
                MockResponse()
                      //  .setBody(testJson)
                        .setResponseCode(200))

        runBlocking {
            val actualResult = movieService.getPopularMovies()
            val gson = Gson()
            val jsonString = gson.toJson(actualResult)
            assertEquals(jsonString, testJson)

        }


    }
}