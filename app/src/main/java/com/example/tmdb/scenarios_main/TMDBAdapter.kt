package com.example.tmdb.scenarios_main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tmdb.R
import com.example.tmdb.entities.Movie
import com.example.tmdb.utils.GlideApp
import kotlinx.android.synthetic.main.movie_list_item.view.*

class TMDBAdapter (val context: Context, val movies: List<Movie>)
    : RecyclerView.Adapter<TMDBAdapter.ViewHolder>() {

    var itemClickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.itemClickListener = clique
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, movies[position], itemClickListener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, movie: Movie, itemClickListener: ((index: Int) -> Unit)?) {
            itemView.movieName.text = movie.title
            itemView.movieGrade.text = movie.vote_average

            GlideApp.with(context)
                .load(movie.poster_url)
                .placeholder(R.drawable.baseline_movie_black_48)
                .centerCrop()
                .into(itemView.imgMovie)

            if(itemClickListener != null) {
                itemView.setOnClickListener {
                    itemClickListener.invoke(adapterPosition)
                }
            }
        }
    }
}