package com.example.tmdb.entities

data class DetailedMovie (
    val backdrop_url:           String,
    val genres:                 List<String>,
    val id:                     Int,
    val imdb_id:                String,
    val original_language:      String,
    val original_title:         String,
    val overview:               String,
    val poster_url:             String,
    val release_date:           String,
    val runtime:                String,
    val tagline:                String,
    val title:                  String,
    val vote_average:           String
)