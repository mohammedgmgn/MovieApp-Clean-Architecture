package com.mahmoud.mohammed.movieapp

import com.mahmoud.mohammed.movieapp.data.local.MovieDetailsEntity
import com.mahmoud.mohammed.movieapp.data.local.MovieEntity
import com.mahmoud.mohammed.movieapp.data.local.ReviewEntity
import com.mahmoud.mohammed.movieapp.data.local.VideoEntity
import com.mahmoud.mohammed.movieapp.data.remote.models.MovieData
import java.io.File


class MovieTestUtils {

    companion object {
        fun getJson(path: String): String {
            val uri = this.javaClass.classLoader.getResource(path)
            val file = File(uri.path)
            return String(file.readBytes())
        }

    }
}