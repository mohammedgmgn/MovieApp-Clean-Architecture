package com.mahmoud.mohammed.movieapp.dagger.viewmodel

import androidx.lifecycle.ViewModel
import com.mahmoud.mohammed.movieapp.presentation.MovieListViewModel
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MovieListViewModel::class)
    abstract fun bindCryptoListViewModel(viewModel: MovieListViewModel) : ViewModel
}