package io.petros.movies.data.di.koin

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mahmoud.mohammed.movieapp.BuildConfig
import com.mahmoud.mohammed.movieapp.R
import com.mahmoud.mohammed.movieapp.data.api.Api
import com.mahmoud.mohammed.movieapp.data.repository.RemoteMoviesDataStore
import com.mahmoud.mohammed.movieapp.domain.MoviesDataStore
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { Gson() }
    single { httpLoggingInterceptor() }
    single { okHttpClient(get(), get()) }
    single { retrofit(get(), get(), get()) }
    single { restApi(get()) }
    single<MoviesDataStore> { RemoteMoviesDataStore(get()) }
}

private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
}

private fun okHttpClient(
    context: Context,
    loggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    val okHttpBuilder = OkHttpClient.Builder()
        .connectTimeout(10000, TimeUnit.MILLISECONDS)
    if (BuildConfig.DEBUG) okHttpBuilder.addInterceptor(loggingInterceptor)
    return okHttpBuilder.build()
}

private fun retrofit(
    context: Context,
    gson: Gson,
    httpClient: OkHttpClient
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(context.getString(R.string.rest_themoviedb_url))
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(httpClient)
        .build()
}

private fun restApi(retrofit: Retrofit): Api = retrofit.create(Api::class.java)
