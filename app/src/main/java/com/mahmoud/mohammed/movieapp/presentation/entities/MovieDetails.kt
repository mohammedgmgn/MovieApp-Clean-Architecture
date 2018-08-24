package com.mahmoud.mohammed.movieapp.presentation.entities


data class MovieDetails(
        var belongsToCollection: Any? = null,
        var budget: Int? = null,
        var homepage: String? = null,
        var imdbId: String? = null,
        var overview: String? = null,
        var revenue: Int? = null,
        var runtime: Int? = null,
        var status: String? = null,
        var tagline: String? = null,
        var videos: List<Video>? = null,
        var reviews: List<Review>? = null,
        var genres: List<String>? = null
)