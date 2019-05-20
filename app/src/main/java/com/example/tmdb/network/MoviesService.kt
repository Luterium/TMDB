package com.example.tmdb.network

import com.example.tmdb.data.model.DetailedMovie
import com.example.tmdb.data.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface MoviesService {

    @GET("movies")
    fun getTopMovies(): Call<List<Movie>>

    @GET()
    fun getMovieInDetail(@Url Url:String):Call<DetailedMovie>
}