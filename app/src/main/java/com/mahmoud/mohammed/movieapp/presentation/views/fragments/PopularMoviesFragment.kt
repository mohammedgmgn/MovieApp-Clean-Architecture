package com.mahmoud.mohammed.movieapp.presentation.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mahmoud.mohammed.movieapp.MovieApplication
import com.mahmoud.mohammed.movieapp.R

fun newMovieListFragment() = MovieListFragment()
val MOVIE_LIST_FRAGMENT_TAG = MovieListFragment::class.java.name

class MovieListFragment : Fragment() {

  /*  @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: PopularMoviesViewModel*/

    override fun onAttach(context: Context?) {
     //   AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       (activity?.application as MovieApplication).createPopularComponenet().inject(this)
        initViewModel()
      //  initAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)

        return view
    }


    private fun initViewModel() {
/*
        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(PopularMoviesViewModel::class.java)*/



    }
}
