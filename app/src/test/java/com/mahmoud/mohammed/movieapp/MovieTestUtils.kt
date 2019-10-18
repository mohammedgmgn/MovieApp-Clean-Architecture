package com.mahmoud.mohammed.movieapp

import com.google.gson.Gson
import com.mahmoud.mohammed.movieapp.data.local.MovieDetailsEntity
import com.mahmoud.mohammed.movieapp.data.local.MovieEntity
import com.mahmoud.mohammed.movieapp.data.local.ReviewEntity
import com.mahmoud.mohammed.movieapp.data.local.VideoEntity
import com.mahmoud.mohammed.movieapp.data.remote.api.MovieListResult
import com.mahmoud.mohammed.movieapp.data.remote.models.MovieData
import java.io.File


class MovieTestUtils {

    companion object {
        fun getJson(path: String): String {
            val uri = this.javaClass.classLoader.getResource(path)
            val file = File(uri.path)
            return String(file.readBytes())
        }

        fun getMovieTestObject(): MovieListResult {

            val gson = Gson()
            val testModel = gson.fromJson(getJson(jsonResponseFileName), MovieListResult::class.java)
            return  testModel;

        }

    }
}