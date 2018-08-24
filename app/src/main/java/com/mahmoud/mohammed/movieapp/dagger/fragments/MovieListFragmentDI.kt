package com.mahmoud.mohammed.movieapp.dagger.fragments

import androidx.fragment.app.Fragment
import com.mahmoud.mohammed.movieapp.presentation.MovieListFragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.FragmentKey
import dagger.multibindings.IntoMap

@Subcomponent/*(modules = ...)*/
interface MovieListFragmentSubcomponent: AndroidInjector<MovieListFragment> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<MovieListFragment>()
}

@Module(subcomponents = arrayOf(MovieListFragmentSubcomponent::class))
abstract class MovieListFragmentModule {
    @Binds
    @IntoMap
    @FragmentKey(MovieListFragment::class)
    abstract fun bindMovieListFragmentInjectorFactory(builder: MovieListFragmentSubcomponent.Builder):
            AndroidInjector.Factory<out Fragment>
}
