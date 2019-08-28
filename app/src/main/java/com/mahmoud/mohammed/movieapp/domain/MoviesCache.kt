package com.mahmoud.mohammed.movieapp.domain

import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.domain.entities.Optional
import io.reactivex.Observable

interface MoviesCache {

    fun clear()
    fun save(movieEntity: MovieData)
    fun remove(movieEntity: MovieData)
    fun saveAll(movieEntities: List<MovieData>)
   suspend fun getAll(): List<MovieData>
    fun get(movieId: Int): Optional<MovieData>
    fun isEmpty(): Boolean
}