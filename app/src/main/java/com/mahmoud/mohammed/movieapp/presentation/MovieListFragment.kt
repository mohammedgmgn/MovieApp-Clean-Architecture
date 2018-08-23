package com.mahmoud.mohammed.movieapp.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import com.mahmoud.mohammed.movieapp.R
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

fun newMovieListFragment() = MovieListFragment()
val MOVIE_LIST_FRAGMENT_TAG = MovieListFragment::class.java.name

class MovieListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MovieListViewModel

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
      //  initAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)

        return view
    }


    private fun initViewModel() {

        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(MovieListViewModel::class.java)
        viewModel.getMovies()


    }
    @SuppressLint("LogNotTimber")
    private fun initAdapter() {
        viewModel.pagedListMovie.observe(this, Observer<PagedList<Movie>> {
            Log.d("movieObserver", "Movies: ${it?.size}")
        })
    }
}
