package com.mahmoud.mohammed.movieapp.data.remote

import com.google.gson.annotations.SerializedName
import com.mahmoud.mohammed.movieapp.common.Api.IMAGES_URL
import com.mahmoud.mohammed.movieapp.data.model.Movie

data class MovieApi(@SerializedName("id") val id: Int,
                    @SerializedName("title") val title: String,
                    @SerializedName("popularity") val popularity: Int,
                    @SerializedName("vote_average") val voteAverage: Int,
                    @SerializedName("poster_path") val posterPath: String,
                    @SerializedName("overview") val overview: String)

fun MovieApi.toMovieEntity() =
        this.run { Movie(id.toLong(), title, popularity, getVoteAverage(voteAverage), getPosterURL(posterPath), overview) }

private fun getVoteAverage(voteAverage: Int) = voteAverage * 10

private fun getPosterURL(posterPath: String) = IMAGES_URL + posterPath

