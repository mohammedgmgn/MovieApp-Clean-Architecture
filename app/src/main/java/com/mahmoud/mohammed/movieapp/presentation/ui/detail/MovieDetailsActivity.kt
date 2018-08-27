package com.mahmoud.mohammed.movieapp.presentation.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mahmoud.mohammed.movieapp.MovieApplication
import com.mahmoud.mohammed.movieapp.R
import com.mahmoud.mohammed.movieapp.common.imagehelper.ImageLoader
import kotlinx.android.synthetic.main.activity_movie_details.*
import javax.inject.Inject

class MovieDetailsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieDetailsVMFactory
    @Inject
    lateinit var imageLoader: ImageLoader

    private lateinit var detailsViewModel: MovieDetailsViewModel
    private lateinit var backdropImage: ImageView
    private lateinit var posterImage: ImageView
    private lateinit var title: TextView
    private lateinit var overview: TextView
    private lateinit var releaseDate: TextView
    private lateinit var score: TextView
    private lateinit var videos: RecyclerView
    private lateinit var videosSection: View
    private lateinit var backButton: View
    // private lateinit var tagsContainer: TagContainerLayout
    private lateinit var favoriteButton: FloatingActionButton
    companion object {
        const val MOVIE_ID: String = "extra_movie_id"
        const val IMAGE_ID: String = "poster_id"

        fun newIntent(context: Context, movieId: Int, posterPath: String?): Intent {
            val i = Intent(context, MovieDetailsActivity::class.java)
            i.putExtra(MOVIE_ID, movieId)
            i.putExtra(IMAGE_ID, posterPath)


            return i
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        (application as MovieApplication).createDetailsComponent().inject(this)
        val movieId=intent.extras.getInt(MOVIE_ID, 0)
        val posterUrl=intent.extras.getString(IMAGE_ID, "")
        imageLoader.load(posterUrl, backdrop)

        factory.movieId = movieId

        detailsViewModel = ViewModelProviders.of(this, factory).get(MovieDetailsViewModel::class.java)

        if (savedInstanceState == null) {
            observeViewState()
            detailsViewModel.getMovieDetails()
        } else {
            detailsViewModel.getMovieDetails()
        }

    }
    private fun observeViewState() {
        detailsViewModel.viewState.observe(this, Observer {
            viewState ->
            handleViewState(viewState)
        })
        detailsViewModel.favoriteState.observe(this, Observer {
            favorite -> //handleFavoriteStateChange(favorite)
        })
        detailsViewModel.errorState.observe(this, Observer { throwable ->
            throwable?.let {
                Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun handleViewState(state: MovieDetailsViewState?) {
        if (state == null)
            return

/*        state.backdropUrl?.let {

            imageLoader.load(it, backdrop)

        }*/


    }
}
