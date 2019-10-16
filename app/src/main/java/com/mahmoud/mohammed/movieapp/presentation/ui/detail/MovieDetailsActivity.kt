package com.mahmoud.mohammed.movieapp.presentation.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.mahmoud.mohammed.movieapp.R
import com.mahmoud.mohammed.movieapp.data.remote.models.MovieData
import com.mahmoud.mohammed.movieapp.extensions.replaceFragment

const val MOVIE_KEY="MovieData"
class MovieDetailsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        if (savedInstanceState == null) {
            val movie  = intent.getParcelableExtra(MOVIE_KEY) as MovieData

             replaceFragment(R.id.activity_detail_id,MovieDetailFragment().apply {
                 arguments = Bundle().apply {
                     putParcelable(MOVIE_KEY, movie)
                 }


             },MOVIE_Details_FRAGMENT_TAG)
            title = getString(R.string.details)
        }



    }

}
