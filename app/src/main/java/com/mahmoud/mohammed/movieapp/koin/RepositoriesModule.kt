package io.petros.movies.data.di.koin

import com.mahmoud.mohammed.movieapp.data.repository.MoviesRepositoryImpl
import com.mahmoud.mohammed.movieapp.domain.MoviesRepository
import org.koin.dsl.module

val repositoriesModule = module {
    factory<MoviesRepository> { MoviesRepositoryImpl(get()) }
}
