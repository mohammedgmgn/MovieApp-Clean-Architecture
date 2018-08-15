package com.mahmoud.mohammed.movieapp.dagger

import com.mahmoud.mohammed.movieapp.MovieApplication
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        AndroidSupportInjectionModule::class
))
interface ApplicationComponent {
    fun inject(app: MovieApplication)
}