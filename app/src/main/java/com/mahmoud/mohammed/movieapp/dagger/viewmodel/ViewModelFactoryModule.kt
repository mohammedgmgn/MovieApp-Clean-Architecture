package com.mahmoud.mohammed.movieapp.dagger.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
  //  @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

}