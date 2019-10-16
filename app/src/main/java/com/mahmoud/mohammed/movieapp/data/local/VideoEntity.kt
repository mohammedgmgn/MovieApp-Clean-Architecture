package com.mahmoud.mohammed.movieapp.data.local

data class VideoEntity(
        var id: String,
        var name: String,
        var youtubeKey: String? = null) {

    companion object {
        const val SOURCE_YOUTUBE = "YouTube"
        const val TYPE_TRAILER = "Trailer"
    }
}