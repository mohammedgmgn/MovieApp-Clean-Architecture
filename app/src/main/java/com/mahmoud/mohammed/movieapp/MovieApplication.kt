package com.mahmoud.mohammed.movieapp

import android.app.Activity
import android.app.Application
import com.mahmoud.mohammed.movieapp.common.Endpoint.THE_MOVIE_URL
import com.mahmoud.mohammed.movieapp.common.Query.API_KEY_VALUE
import com.mahmoud.mohammed.movieapp.dagger.application.AppModule
import com.mahmoud.mohammed.movieapp.dagger.application.DaggerMainComponent
import com.mahmoud.mohammed.movieapp.dagger.application.MainComponent
import com.mahmoud.mohammed.movieapp.dagger.data.DataModule
import com.mahmoud.mohammed.movieapp.dagger.network.NetworkModule
import com.mahmoud.mohammed.movieapp.dagger.popular.PopularMoviesModule
import com.mahmoud.mohammed.movieapp.dagger.popular.PopularSubComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Inject

class MovieApplication : Application()//, HasActivityInjector
 {
    lateinit var mainComponent: MainComponent

    private var popularMoviesComponent: PopularSubComponent? = null

   /* @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>
    */
    override fun onCreate() {
        super.onCreate()
        initDependencies()

    }

    private fun initDependencies() {
        mainComponent = DaggerMainComponent.builder()
                .appModule(AppModule(applicationContext))
                .networkModule(NetworkModule(THE_MOVIE_URL, API_KEY_VALUE))
                .dataModule(DataModule())
                .build()

       /* DaggerApplicationComponent.create()
                .inject(this)*/


    }

    fun createPopularComponenet(): PopularSubComponent {
        popularMoviesComponent = mainComponent.plus(PopularMoviesModule())
        return popularMoviesComponent!!
    }


  //  override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
}