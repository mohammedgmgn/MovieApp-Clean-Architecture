package com.mahmoud.mohammed.movieapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mahmoud.mohammed.movieapp.common.CONSTANTS.TABLE_MOVIE

@Entity(tableName = TABLE_MOVIE)
data class Movie(@PrimaryKey val id: Long,
                 val title: String,
                 val popularity: Int,
                 val voteAverage: Int,
                 val posterUrl: String,
                 val description: String)
