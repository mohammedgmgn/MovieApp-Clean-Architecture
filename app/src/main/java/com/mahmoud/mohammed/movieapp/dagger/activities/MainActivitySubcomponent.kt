package com.mahmoud.mohammed.movieapp.dagger.activities

import com.mahmoud.mohammed.movieapp.dagger.fragments.MovieListFragmentModule
import com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.activities.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector



@Subcomponent(modules = arrayOf(MovieListFragmentModule::class))
interface MainActivitySubcomponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}
