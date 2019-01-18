package com.example.tmdb.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://desafio-mobile.nyc3.digitaloceanspaces.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun createMoviesService() = retrofit.create(MoviesService::class.java)
}