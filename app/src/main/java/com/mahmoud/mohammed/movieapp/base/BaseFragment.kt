package com.mahmoud.mohammed.movieapp.base

import android.annotation.SuppressLint
import android.app.ActivityOptions
import androidx.fragment.app.Fragment
import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import com.mahmoud.mohammed.movieapp.presentation.entities.Movie
import com.mahmoud.mohammed.movieapp.presentation.ui.detail.MovieDetailsActivity

open class BaseFragment: Fragment() {

    @SuppressLint("NewApi")
    protected fun navigateToMovieDetailsScreen(movie: MovieData) {
        var activityOptions: ActivityOptions? = null

        startActivity(MovieDetailsActivity.newIntent(
                context!!,
                movie.id,
                movie.posterPath), activityOptions?.toBundle())

        activity?.overridePendingTransition(0, 0)
    }
}