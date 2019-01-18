package com.example.tmdb.scenarios_main

import com.example.tmdb.entities.Movie

interface MainContract {
    interface View{
        fun showMessage(msg: String)
        fun showList(movies: List<Movie>)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun onLoadList()
    }
}