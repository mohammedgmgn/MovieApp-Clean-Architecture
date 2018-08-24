package com.mahmoud.mohammed.movieapp.dagger.popular

import com.mahmoud.mohammed.movieapp.presentation.MovieListFragment
import dagger.Subcomponent

@Subcomponent(modules = [PopularMoviesModule::class])
interface PopularSubComponent {
    fun inject(popularMoviesFragment: MovieListFragment)
}
