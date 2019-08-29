package io.petros.movies.presentation.di.koin

import com.mahmoud.mohammed.movieapp.presentation.common.SharedViewModel
import com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments.PopularMoviesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PopularMoviesViewModel(get()) }
}
