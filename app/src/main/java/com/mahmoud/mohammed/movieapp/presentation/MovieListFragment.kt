package com.mahmoud.mohammed.movieapp.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import com.mahmoud.mohammed.movieapp.R
import com.mahmoud.mohammed.movieapp.common.ViewModelHelper
import com.mahmoud.mohammed.movieapp.data.model.Movie
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import java.security.cert.Extension
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
