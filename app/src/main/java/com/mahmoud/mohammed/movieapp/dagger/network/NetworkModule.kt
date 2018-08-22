package com.mahmoud.mohammed.movieapp.dagger.network

import com.mahmoud.mohammed.movieapp.common.Api.THE_MOVIE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
//
//http://api.themoviedb.org/
private const val BASE_URL = THE_MOVIE_URL

@Module
class NetworkModule {
    @Provides
    fun providesMoviesApi(retrofit: Retrofit) = retrofit.create(MoviesService::class.java)

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient) =
            Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()


    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
    }
}