package com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.api.load
import com.mahmoud.mohammed.movieapp.R
import com.mahmoud.mohammed.movieapp.data.entities.MovieData
import kotlinx.android.synthetic.main.popular_movies_item_row.view.*

class PopularMoviesAdapter(private val context: Context?, private val onMovieSelected:
                                       (MovieData, View) -> Unit) :

        RecyclerView.Adapter<PopularMoviesAdapter.MovieCellViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCellViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.popular_movies_item_row,
                parent,
                false)
        return MovieCellViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieCellViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie,context!!, onMovieSelected)
    }

    private val movies: MutableList<MovieData> = mutableListOf()


    override fun getItemCount(): Int {
        return movies.size
    }


    fun addMovies(movies: List<MovieData>) {
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    class MovieCellViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: MovieData,context: Context, listener: (MovieData, View) -> Unit) = with(itemView) {
            title.text = movie.originalTitle
            movie.posterPath?.let {
                image.load(context.getString(R.string.rest_themoviedb_image_url)+it)
            }
            setOnClickListener { listener(movie, itemView) }
        }

    }
}