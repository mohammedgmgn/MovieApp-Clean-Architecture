package com.mahmoud.mohammed.movieapp.domain.entities

import com.mahmoud.mohammed.movieapp.domain.entities.MovieDetailsEntity

data class MovieEntity(

        var id: Int = 0,
        var voteCount: Int = 0,
        var video: Boolean = false,
        var voteAverage: Double = 0.0,
        var popularity: Double = 0.0,
        var adult: Boolean = false,
        var details: MovieDetailsEntity? = null,
        var title: String,
        var posterPath: String?,
        var originalLanguage: String,
        var originalTitle: String,
        var backdropPath: String?,
        var releaseDate: String,
        var overview: String? = null
)