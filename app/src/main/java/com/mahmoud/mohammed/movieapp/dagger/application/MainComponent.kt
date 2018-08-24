package com.mahmoud.mohammed.movieapp.dagger.application

import com.mahmoud.mohammed.movieapp.dagger.activities.MainActivityModule
import com.mahmoud.mohammed.movieapp.dagger.data.DataModule
import com.mahmoud.mohammed.movieapp.dagger.network.NetworkModule
import com.mahmoud.mohammed.movieapp.dagger.popular.PopularMoviesModule
import com.mahmoud.mohammed.movieapp.dagger.popular.PopularSubComponent
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

const val SCHEDULER_MAIN_THREAD = "mainThread"
const val SCHEDULER_IO = "io"

@Singleton
@Component(modules = [
    (AppModule::class),
    (NetworkModule::class)
,    (DataModule::class)
    ,(AndroidSupportInjectionModule::class)
    ,(MainActivityModule::class)
    /*
    ,(MovieListFragmentModule::class)
,(ViewModelModule::class::class)
*/

])

interface MainComponent {
    fun plus(popularMoviesModule: PopularMoviesModule): PopularSubComponent

}
