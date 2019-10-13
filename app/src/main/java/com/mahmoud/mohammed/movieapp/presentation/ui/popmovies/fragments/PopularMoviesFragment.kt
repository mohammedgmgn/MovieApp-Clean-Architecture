package com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahmoud.mohammed.movieapp.R
import com.mahmoud.mohammed.movieapp.data.api.MovieListResult
import com.mahmoud.mohammed.movieapp.extensions.launchActivity
import com.mahmoud.mohammed.movieapp.presentation.common.SharedViewModel
import com.mahmoud.mohammed.movieapp.presentation.ui.detail.MOVIE_KEY
import com.mahmoud.mohammed.movieapp.presentation.ui.detail.MovieDetailsActivity
import kotlinx.android.synthetic.main.fragment_movie_list.*
import org.koin.android.ext.android.inject

fun newMovieListFragment() = MovieListFragment()
val MOVIE_LIST_FRAGMENT_TAG = MovieListFragment::class.java.name

class MovieListFragment : Fragment() {

    private val viewModel: PopularMoviesViewModel by inject()
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var popularMoviesAdapter: PopularMoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.state.observe(this, Observer<UiModel> { uiModel ->
            if (uiModel != null) render(uiModel)
        })
        viewModel.getPopularMovies()



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        

    }
    private fun render(uiModel: UiModel) {
        when (uiModel) {
            is UiModel.Success -> showMovies(uiModel.data)
            is UiModel.Error -> showError(uiModel.error)
        }
    }

    private fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()

    }

    private fun showMovies(moviesData: MovieListResult) {
        moviesData.movies.let { popularMoviesAdapter.addMovies(it) }
    }


/*
    private fun handleViewState(state: UiModel) {
        progressBar.visibility = if (state.showLoading) View.VISIBLE else View.GONE
        state.movies?.let { popularMoviesAdapter.addMovies(it) }
    }
*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = popular_movies_progress
        val intent = Intent(context, MovieDetailsActivity::class.java)

        popularMoviesAdapter = PopularMoviesAdapter(context) { movie, _ ->
            intent.putExtra(MOVIE_KEY, movie)
            startActivity(intent)

        }
        recyclerView = popular_movies_recyclerview
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.adapter = popularMoviesAdapter
    }


}
