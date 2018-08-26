package com.mahmoud.mohammed.movieapp.dagger.details

import com.mahmoud.mohammed.movieapp.dagger.DI
import com.mahmoud.mohammed.movieapp.data.mappers.MovieEntityMovieMapper
import com.mahmoud.mohammed.movieapp.domain.MoviesCache
import com.mahmoud.mohammed.movieapp.domain.MoviesRepository
import com.mahmoud.mohammed.movieapp.domain.usecases.CheckFavoriteStatus
import com.mahmoud.mohammed.movieapp.domain.usecases.GetMovieDetails
import com.mahmoud.mohammed.movieapp.domain.usecases.RemoveFavoriteMovie
import com.mahmoud.mohammed.movieapp.domain.usecases.SaveFavoriteMovie
import com.mahmoud.mohammed.movieapp.presentation.common.ASyncTransformer
import com.mahmoud.mohammed.movieapp.presentation.ui.detail.MovieDetailsVMFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class MovieDetailsModule {

    @Provides
    fun provideRemoveFavoriteMovie(@Named(DI.favoritesCache) moviesCache: MoviesCache): RemoveFavoriteMovie {
        return RemoveFavoriteMovie(ASyncTransformer(), moviesCache)
    }

    @Provides
    fun provideCheckFavoriteStatus(@Named(DI.favoritesCache) moviesCache: MoviesCache): CheckFavoriteStatus {
        return CheckFavoriteStatus(ASyncTransformer(), moviesCache)
    }

    @Provides
    fun provideSaveFavoriteMovieUseCase(@Named(DI.favoritesCache) moviesCache: MoviesCache): SaveFavoriteMovie {
        return SaveFavoriteMovie(ASyncTransformer(), moviesCache)
    }

    @Provides
    fun provideGetMovieDetailsUseCase(moviesRepository: MoviesRepository): GetMovieDetails {
        return GetMovieDetails(ASyncTransformer(), moviesRepository)
    }

    @Provides
    fun provideMovieDetailsVMFactory(getMovieDetails: GetMovieDetails,
                                     saveFavoriteMovie: SaveFavoriteMovie,
                                     removeFavoriteMovie: RemoveFavoriteMovie,
                                     checkFavoriteStatus: CheckFavoriteStatus,
                                     mapper: MovieEntityMovieMapper): MovieDetailsVMFactory {
        return MovieDetailsVMFactory(getMovieDetails, saveFavoriteMovie, removeFavoriteMovie, checkFavoriteStatus, mapper)
    }
}