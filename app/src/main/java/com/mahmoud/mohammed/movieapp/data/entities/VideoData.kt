package com.mahmoud.mohammed.movieapp.data.entities


data class VideoData(
        var id: String,
        var name: String,
        var key: String? = null,
        var site: String? = null,
        var type: String? = null
)