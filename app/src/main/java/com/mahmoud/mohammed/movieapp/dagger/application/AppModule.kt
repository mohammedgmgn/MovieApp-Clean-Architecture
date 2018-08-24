package com.mahmoud.mohammed.movieapp.dagger.application

import android.content.Context
import com.mahmoud.mohammed.movieapp.common.ImageLoader
import com.mahmoud.mohammed.movieapp.common.PicassoImageLoader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton


@Module
class AppModule constructor(context: Context){

    private val appContext = context.applicationContext

    @Singleton
    @Provides
    fun provideAppContext(): Context {
        return appContext
    }

    @Singleton
    @Provides
    fun provideImageLoader(context: Context) : ImageLoader {
        return PicassoImageLoader(Picasso.with(context))
    }

    @Provides
    @Named(SCHEDULER_MAIN_THREAD)
    fun provideAndroidMainThreadScheduler() : Scheduler = AndroidSchedulers.mainThread()

    @Provides
    @Named(SCHEDULER_IO)
    fun provideIoScheduler() : Scheduler = Schedulers.io()

}
