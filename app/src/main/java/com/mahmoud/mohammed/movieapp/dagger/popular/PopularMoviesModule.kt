package com.mahmoud.mohammed.movieapp.dagger.popular

import com.mahmoud.mohammed.movieapp.MovieEntityMovieMapper
import com.mahmoud.mohammed.movieapp.domain.MoviesRepository
import com.mahmoud.mohammed.movieapp.domain.usecases.GetPopularMovies
import com.mahmoud.mohammed.movieapp.presentation.views.fragments.PopularMoviesVMFactory
import com.mahmoud.mohammed.movieapp.presentation.common.ASyncTransformer
import dagger.Module
import dagger.Provides

@Module
class PopularMoviesModule {
    @PopularScope
    @Provides
    fun provideGetPopularMoviesUseCase(moviesRepository: MoviesRepository): GetPopularMovies {
        return GetPopularMovies(ASyncTransformer(), moviesRepository)
    }
    @PopularScope
    @Provides
    fun providePopularMoviesVMFactory(useCase: GetPopularMovies, mapper: MovieEntityMovieMapper)
            : PopularMoviesVMFactory {
        return PopularMoviesVMFactory(useCase, mapper)
    }
}