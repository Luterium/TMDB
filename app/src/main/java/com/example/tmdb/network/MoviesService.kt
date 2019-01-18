package com.example.tmdb.network

import com.example.tmdb.entities.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("movies")
    fun getTopMovies(): Call<MovieList>

    @GET("movies/")
    fun getMovieByID(@Query("movieID")query: String):Call<MovieList>
}