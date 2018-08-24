package com.mahmoud.mohammed.movieapp.presentation.entities

data class Review(

        var id: String,
        var author: String,
        var content: String? = null
)