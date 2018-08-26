package com.mahmoud.mohammed.movieapp.presentation.ui.detail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

import com.mahmoud.mohammed.movieapp.R
import com.mahmoud.mohammed.movieapp.common.imagehelper.ImageLoader
import javax.inject.Inject

class MovieDetailsFragment : Fragment() {

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
        fun newInstance() = MovieDetailsFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.movie_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        detailsViewModel = ViewModelProviders.of(this).get(MovieDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }



}
