package com.mahmoud.mohammed.movieapp.dagger.application

import com.mahmoud.mohammed.movieapp.MovieApplication
import com.mahmoud.mohammed.movieapp.dagger.activities.MainActivityModule
import com.mahmoud.mohammed.movieapp.dagger.network.NetworkModule
import com.mahmoud.mohammed.movieapp.dagger.viewmodel.ViewModelFactoryModule
import com.mahmoud.mohammed.movieapp.dagger.viewmodel.ViewModelModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelFactoryModule::class,
        NetworkModule::class
        , ViewModelModule::class
        , MainActivityModule::class
))
interface ApplicationComponent {
    fun inject(app: MovieApplication)
}