package com.mahmoud.mohammed.movieapp.dagger.details

import com.mahmoud.mohammed.movieapp.dagger.details.DetailsScope
import com.mahmoud.mohammed.movieapp.dagger.details.MovieDetailsModule
import com.mahmoud.mohammed.movieapp.presentation.ui.detail.MovieDetailsActivity
import dagger.Subcomponent

@DetailsScope
@Subcomponent(modules = [MovieDetailsModule::class])
interface MovieDetailsSubComponent {
    fun inject(movieDetailsActivity: MovieDetailsActivity)
}