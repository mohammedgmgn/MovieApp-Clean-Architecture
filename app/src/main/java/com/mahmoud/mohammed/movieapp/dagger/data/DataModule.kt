package com.mahmoud.mohammed.movieapp.dagger.data

import android.content.Context
import androidx.room.Room
import com.mahmoud.mohammed.movieapp.dagger.DI
import com.mahmoud.mohammed.movieapp.data.api.Api
import com.mahmoud.mohammed.movieapp.data.db.MoviesDatabase
import com.mahmoud.mohammed.movieapp.data.db.RoomFavoritesMovieCache
import com.mahmoud.mohammed.movieapp.data.mappers.DetailsDataMovieEntityMapper
import com.mahmoud.mohammed.movieapp.data.mappers.MovieDataEntityMapper
import com.mahmoud.mohammed.movieapp.data.mappers.MovieEntityDataMapper
import com.mahmoud.mohammed.movieapp.data.repository.CachedMoviesDataStore
import com.mahmoud.mohammed.movieapp.data.repository.MemoryMoviesCache
import com.mahmoud.mohammed.movieapp.data.repository.MoviesRepositoryImpl
import com.mahmoud.mohammed.movieapp.data.repository.RemoteMoviesDataStore
import com.mahmoud.mohammed.movieapp.domain.MoviesCache
import com.mahmoud.mohammed.movieapp.domain.MoviesDataStore
import com.mahmoud.mohammed.movieapp.domain.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context): MoviesDatabase {
        return Room.databaseBuilder(
                context,
                MoviesDatabase::class.java,
                "movies_db").build()
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: Api,
                               @Named(DI.inMemoryCache) cache: MoviesCache,
                               movieDataMapper: MovieDataEntityMapper,
                               detailedDataMapper: DetailsDataMovieEntityMapper): MoviesRepository {

        return MoviesRepositoryImpl(api, cache, movieDataMapper, detailedDataMapper)
    }

    @Singleton
    @Provides
    @Named(DI.inMemoryCache)
    fun provideInMemoryMoviesCache(): MoviesCache {
        return MemoryMoviesCache()
    }

    @Singleton
    @Provides
    @Named(DI.favoritesCache)
    fun provideFavoriteMoviesCache(moviesDatabase: MoviesDatabase,
                                   entityDataMapper: MovieEntityDataMapper,
                                   dataEntityMapper: MovieDataEntityMapper): MoviesCache {
        return RoomFavoritesMovieCache(moviesDatabase, entityDataMapper, dataEntityMapper)
    }

    @Singleton
    @Provides
    @Named(DI.remoteDataStore)
    fun provideRemoteMovieDataStore(api: Api, movieDataMapper: MovieDataEntityMapper, detailedDataMapper: DetailsDataMovieEntityMapper): MoviesDataStore {
        return RemoteMoviesDataStore(api, movieDataMapper, detailedDataMapper)
    }

    @Singleton
    @Provides
    @Named(DI.cachedDataStore)
    fun provideCachedMoviesDataStore(moviesCache: MoviesCache): MoviesDataStore {
        return CachedMoviesDataStore(moviesCache)
    }

}