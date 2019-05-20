package com.example.tmdb.presentation.scene.movieList

import com.example.tmdb.data.model.DetailedMovie
import com.example.tmdb.data.model.Movie

interface MainContract {
    interface View{
        fun showMessage(msg: String)
        fun showList(movies: List<Movie>)
        fun showLoading()
        fun listMovieInDetail(movie: DetailedMovie)
        fun hideLoading()
    }

    interface Presenter {
        fun onLoadList()
        fun onClickMovie(movie: Movie)
    }
}