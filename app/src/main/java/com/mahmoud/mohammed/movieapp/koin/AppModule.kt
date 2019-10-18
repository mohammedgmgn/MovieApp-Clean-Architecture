package com.mahmoud.mohammed.movieapp.koin

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mahmoud.mohammed.movieapp.BuildConfig
import com.mahmoud.mohammed.movieapp.data.remote.api.MovieService
import com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments.PopularMoviesViewModel
import com.mahmoud.mohammed.movieapp.data.Repository
import com.mahmoud.mohammed.movieapp.data.RepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    single { Gson() }
    single { httpLoggingInterceptor() }
    single { okHttpClient(get(), get()) }
    single { retrofit(get(), get(), get()) }
    single { restApi(get()) }
    single<Repository> { RepositoryImpl(get()) }
    viewModel { PopularMoviesViewModel(get()) }


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
        .baseUrl(Endpoint.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(httpClient)
        .build()
}


private fun restApi(retrofit: Retrofit): MovieService = retrofit.create(MovieService::class.java)
