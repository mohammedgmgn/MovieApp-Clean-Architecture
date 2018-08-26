package com.mahmoud.mohammed.movieapp.dagger.favorites

import com.mahmoud.mohammed.movieapp.presentation.ui.favorites.FavoriteMoviesFragment
import dagger.Subcomponent

@FavoritesScope
@Subcomponent(modules = [FavoriteModule::class])
interface FavoritesSubComponent {
    fun inject(favoriteMoviesFragment: FavoriteMoviesFragment)
}