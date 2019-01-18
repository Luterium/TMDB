package com.example.tmdb.entities

import java.io.Serializable

data class Movie(
    val id:             String,
    val vote_average:   String,
    val title:          String,
    val poster_url:     String,
    val genres:         List<String>,
    val release_date:   String
):Serializable