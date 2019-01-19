package com.example.tmdb.network

import com.example.tmdb.entities.DetailedMovie
import com.example.tmdb.entities.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MoviesService {

    @GET("movies")
    fun getTopMovies(): Call<List<Movie>>

    @GET()
    fun getMovieInDetail(@Url Url:String):Call<DetailedMovie>
}