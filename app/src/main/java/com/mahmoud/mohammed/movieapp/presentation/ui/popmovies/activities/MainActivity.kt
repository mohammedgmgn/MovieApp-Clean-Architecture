package com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mahmoud.mohammed.movieapp.R
import com.mahmoud.mohammed.movieapp.extensions.replaceFragment
import com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments.MOVIE_LIST_FRAGMENT_TAG
import com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments.newMovieListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        if (savedInstanceState == null) {
            replaceFragment(R.id.container,newMovieListFragment(), MOVIE_LIST_FRAGMENT_TAG)

                title = getString(R.string.popular)
            }

    }
}


