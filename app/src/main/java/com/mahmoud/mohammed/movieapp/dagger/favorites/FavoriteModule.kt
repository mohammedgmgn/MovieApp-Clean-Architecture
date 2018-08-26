package com.mahmoud.mohammed.movieapp.dagger.favorites

import com.mahmoud.mohammed.movieapp.dagger.DI
import com.mahmoud.mohammed.movieapp.data.mappers.MovieEntityMovieMapper
import com.mahmoud.mohammed.movieapp.domain.MoviesCache
import com.mahmoud.mohammed.movieapp.domain.usecases.GetFavoriteMovies
import com.mahmoud.mohammed.movieapp.presentation.common.ASyncTransformer
import com.mahmoud.mohammed.movieapp.presentation.ui.favorites.FavoriteMoviesVMFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class FavoriteModule {

    @Provides
    fun provideGetFavoriteMovies(@Named(DI.favoritesCache) moviesCache: MoviesCache): GetFavoriteMovies {
        return GetFavoriteMovies(ASyncTransformer(), moviesCache)
    }

    @Provides
    fun provideFavoriteMoviesVMFactory(getFavoriteMovies: GetFavoriteMovies,
                                       movieEntityMoveMapper: MovieEntityMovieMapper): FavoriteMoviesVMFactory {
        return FavoriteMoviesVMFactory(getFavoriteMovies, movieEntityMoveMapper)
    }
}