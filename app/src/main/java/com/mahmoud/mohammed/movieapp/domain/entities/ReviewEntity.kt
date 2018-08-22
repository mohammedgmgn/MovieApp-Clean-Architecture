package com.mahmoud.mohammed.movieapp.domain.entities
data class ReviewEntity (
        var id: String,
        var author: String,
        var content: String? = null
)