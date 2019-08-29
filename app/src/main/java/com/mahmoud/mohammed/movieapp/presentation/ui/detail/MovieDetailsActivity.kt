package com.mahmoud.mohammed.movieapp.presentation.ui.detail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mahmoud.mohammed.movieapp.R
import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.domain.entities.MovieEntity
import com.mahmoud.mohammed.movieapp.extensions.replaceFragment
import com.mahmoud.mohammed.movieapp.presentation.common.SharedViewModel
import org.koin.android.ext.android.inject
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
