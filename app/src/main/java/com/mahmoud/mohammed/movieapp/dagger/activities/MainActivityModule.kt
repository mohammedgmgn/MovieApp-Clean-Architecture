package com.mahmoud.mohammed.movieapp.dagger.activities

import android.app.Activity
import com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.activities.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap


@Module(subcomponents = arrayOf(MainActivitySubcomponent::class))
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivityInjectorFactory(builder: MainActivitySubcomponent.Builder)
            : AndroidInjector.Factory<out Activity>
}