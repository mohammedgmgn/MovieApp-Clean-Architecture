package com.mahmoud.mohammed.movieapp.dagger.popular

import com.mahmoud.mohammed.movieapp.presentation.views.fragments.MovieListFragment
import dagger.Subcomponent
@PopularScope
@Subcomponent(modules = [PopularMoviesModule::class])
interface PopularSubComponent {
    fun inject(popularMoviesFragment: MovieListFragment)
}
