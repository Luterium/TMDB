package com.example.tmdb.scenariosMain

import com.example.tmdb.entities.DetailedMovie
import com.example.tmdb.entities.Movie

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