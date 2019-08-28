package io.petros.movies.domain.di.koin

import com.mahmoud.mohammed.movieapp.domain.usecases.GetPopularMovies
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetPopularMovies(get()) }
}
