package com.example.tmdb.scenarios_main

import com.example.tmdb.entities.MovieList
import com.example.tmdb.network.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.View) : MainContract.Presenter {

    override fun onLoadList(){

        view.showLoading()

        val moviesService = RetrofitInitializer().createMoviesService()

        val call = moviesService.getTopMovies()

        call.enqueue(object : Callback<MovieList> {
            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showList(response.body()!!.movies)
                }else {
                    view.showMessage("Esse drink não está disponível")
                }
            }
        })

    }
}