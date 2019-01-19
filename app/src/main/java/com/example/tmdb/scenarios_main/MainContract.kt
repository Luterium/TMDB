package com.example.tmdb.scenarios_main

import com.example.tmdb.entities.Movie

interface MainContract {
    interface View{
        fun showMessage(msg: String)
        fun showList(movies: List<Movie>)
        fun showLoading()
        fun listMovieInDetail(movie: Movie)
        fun hideLoading()
    }

    interface Presenter {
        fun onLoadList()
        fun onClickMovie(movie: Movie)
    }
}