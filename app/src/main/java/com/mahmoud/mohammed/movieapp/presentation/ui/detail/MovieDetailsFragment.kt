package com.mahmoud.mohammed.movieapp.presentation.ui.detail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.api.load

import com.mahmoud.mohammed.movieapp.R
import com.mahmoud.mohammed.movieapp.data.remote.models.MovieData
import kotlinx.android.synthetic.main.movie_details_fragment.*

fun MovieDetailFragment() = MovieDetailsFragment()
val MOVIE_Details_FRAGMENT_TAG = MovieDetailsFragment::class.java.name

class MovieDetailsFragment : Fragment() {
    private lateinit var detailsViewModel: MovieDetailsViewModel
    lateinit var movieData: MovieData


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        arguments?.getParcelable<MovieData>(MOVIE_KEY)?.let {
            movieData = it
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
      return inflater.inflate(R.layout.movie_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        toolbar.title = movieData.title
        movie_cover.load((context?.getString(R.string.rest_themoviedb_image_url) + movieData.backdropPath))


    }
    /* private fun observeViewState() {
     detailsViewModel.viewState.observe(this, Observer { viewState ->
         handleViewState(viewState)
     })
     detailsViewModel.favoriteState.observe(this, Observer { favorite ->
         handleFavoriteStateChange(favorite)
     })
     detailsViewModel.errorState.observe(this, Observer { throwable ->
         throwable?.let {
             Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
         }
     })
 }

 @SuppressLint("RestrictedApi")
 private fun handleFavoriteStateChange(favorite: Boolean?) {
     if (favorite == null) return
     fav_btn.visibility = View.VISIBLE
     fav_btn.setImageDrawable(
             if (favorite)
                 ContextCompat.getDrawable(this, R.drawable.ic_like)
             else
                 ContextCompat.getDrawable(this, R.drawable.ic_like_outline))
 }

 private fun handleViewState(state: MovieDetailsViewState?) {
     if (state == null)
         return

     state.backdropUrl?.let {
         posterimage.load(it)
     }
     movie_title.text = state.title
     date_status.text = state.releaseDate


 }*/


}
