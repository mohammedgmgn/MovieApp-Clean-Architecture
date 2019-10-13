package com.mahmoud.mohammed.movieapp

import android.app.Application
import com.mahmoud.mohammed.movieapp.koin.data.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApplication : Application()
{

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            // Android context
            androidContext(this@MovieApplication)
            // modules
            modules(listOf(appModule))
        }
    }
}