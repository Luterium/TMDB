package com.example.tmdb.data.model

data class Movie(
    val id:             Int,
    val vote_average:   String,
    val title:          String,
    val poster_url:     String,
    val genres:         List<String>,
    val release_date:   String
)