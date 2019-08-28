package com.mahmoud.mohammed.movieapp

import android.app.Activity
import android.app.Application
import com.mahmoud.mohammed.movieapp.common.Endpoint.THE_MOVIE_URL
import com.mahmoud.mohammed.movieapp.common.Query.API_KEY_VALUE
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.petros.movies.data.di.koin.networkModule
import io.petros.movies.data.di.koin.repositoriesModule
import io.petros.movies.domain.di.koin.useCasesModule
import io.petros.movies.presentation.di.koin.appModule
import javax.inject.Inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApplication : Application()
{

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            // Android context
            androidContext(this@MovieApplication)
            // modules
            modules(listOf(appModule, networkModule,useCasesModule,repositoriesModule))
        }
    }
}