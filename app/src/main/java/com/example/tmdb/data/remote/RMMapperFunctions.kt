package com.example.tmdb.data.remote

import com.example.tmdb.data.model.DetailedMovie
import com.example.tmdb.data.model.Movie

fun MovieRM.toModel(): Movie = Movie(id, vote_average, title, poster_url, genres, release_date)

fun DetailedMovieRM.toModel(): DetailedMovie = DetailedMovie(backdrop_url, genres, id, imdb_id, original_language,
                                                             original_title, overview, poster_url, release_date, runtime, tagline, title, vote_average)