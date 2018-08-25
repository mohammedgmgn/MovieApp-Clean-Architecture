package com.mahmoud.mohammed.movieapp.presentation.ui.popmovies.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mahmoud.mohammed.movieapp.R
import com.mahmoud.mohammed.movieapp.common.imagehelper.ImageLoader
import com.mahmoud.mohammed.movieapp.presentation.entities.Movie
import kotlinx.android.synthetic.main.popular_movies_item_row.view.*

class PopularMoviesAdapter constructor(private val imageLoader: ImageLoader,
                                       private val onMovieSelected:
                                       (Movie, View) -> Unit) :
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
        holder.bind(movie, imageLoader, onMovieSelected)
    }

    private val movies: MutableList<Movie> = mutableListOf()



    override fun getItemCount(): Int {
        return movies.size
    }


    fun addMovies(movies: List<Movie>) {
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    class MovieCellViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Movie, imageLoader: ImageLoader, listener: (Movie, View) -> Unit) = with(itemView) {
            title.text = movie.originalTitle
            movie.posterPath?.let { imageLoader.load(it, image) }
            setOnClickListener { listener(movie, itemView) }
        }

    }
}