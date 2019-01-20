package com.example.tmdb.scenariosMain

import com.example.tmdb.entities.DetailedMovie
import com.example.tmdb.entities.Movie
import com.example.tmdb.network.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.View) : MainContract.Presenter {

    override fun onLoadList(){

        view.showLoading()

        val moviesService = RetrofitInitializer().createMoviesService()

        val call = moviesService.getTopMovies()

        call.enqueue(object : Callback<List<Movie>> {
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showList(response.body()!!)
                }else {
                    view.showMessage("Esses filmes não estão disponíveis")
                }
            }
        })
    }

    override fun onClickMovie(movie: Movie) {
        view.showLoading()
        val wholeUrl = StringBuilder()
        wholeUrl.append("https://desafio-mobile.nyc3.digitaloceanspaces.com/movies/")
        wholeUrl.append(movie.id)
        val moviesService = RetrofitInitializer().createMoviesService()
        val call = moviesService.getMovieInDetail(wholeUrl.toString())
        call.enqueue(object : Callback<DetailedMovie> {
            override fun onFailure(call: Call<DetailedMovie>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }
            override fun onResponse(call: Call<DetailedMovie>, response: Response<DetailedMovie>) {
                view.hideLoading()
                if(response.body() != null) {
                    view.listMovieInDetail(response.body()!!)
                } else {
                    view.showMessage("Esse filme não está disponível")
                }
            }
        })
    }

}