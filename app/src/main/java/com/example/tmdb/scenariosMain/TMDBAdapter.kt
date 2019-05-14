package com.example.tmdb.scenariosMain

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmdb.R
import com.example.tmdb.entities.Movie
import com.example.tmdb.utils.GlideApp
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.movie_list_item.view.*

class TMDBAdapter(val context: Context, val movies: List<Movie>, val itemClickListener: ((index: Int) -> Unit)) :
    GroupAdapter<ViewHolder>() {

    init{
        movies.forEach{movie ->
            add(MovieItem(movie))
        }
    }

    inner class MovieItem(val movie: Movie) : Item() {

        override fun bind(viewHolder: ViewHolder, position: Int) {
            viewHolder.containerView.movieName.text = movie.title
            viewHolder.containerView.movieGrade.text = movie.vote_average

            GlideApp.with(context)
                .load(movie.poster_url)
                .placeholder(R.drawable.baseline_movie_black_48)
                .centerCrop()
                .into(viewHolder.containerView.imgMovie)

            viewHolder.containerView.setOnClickListener {
                itemClickListener(position)
            }
        }

        override fun getLayout(): Int = R.layout.movie_list_item

    }
}
