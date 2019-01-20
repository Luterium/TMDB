package com.example.tmdb.scenariosMain


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.tmdb.R
import com.example.tmdb.entities.DetailedMovie
import com.example.tmdb.utils.GlideApp
import kotlinx.android.synthetic.main.fragment_detailed_movie.*

class DetailedMovieFragment : Fragment() {

    companion object {
        private val DETAILED_MOVIE = "detailed_movie"

        fun newInstance(detailedMovie: DetailedMovie) =
            DetailedMovieFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(DETAILED_MOVIE, detailedMovie)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailed_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailedMovie = getDetailedMovie()

        val stringBuilderTime = StringBuilder()
        val stringBuilderGenres = StringBuilder()

        val genresStrings: List<String> = detailedMovie.genres

        stringBuilderTime.append((detailedMovie.runtime.toInt()/60).toString())
        stringBuilderTime.append("h ").append((detailedMovie.runtime.toInt()%60).toString()).append("min")
        val genresIterator = genresStrings.listIterator()

        for(item in genresIterator){
            if(!item.isNullOrBlank()){
                stringBuilderGenres.append(item).append("   ")
            }
        }

        movieDetailedName.text = detailedMovie.title
        GlideApp.with(this)
            .load(detailedMovie.poster_url)
            .placeholder(R.drawable.baseline_movie_black_48)
            .centerCrop()
            .into(movieDetailedPoster)

        movieYear.text = detailedMovie.release_date.subSequence(0,4)
        movieDuration.text = stringBuilderTime
        movieGenres.text = stringBuilderGenres
        movieDetailGrade.text = detailedMovie.vote_average
        movieOverview.text = detailedMovie.overview
    }


    fun getDetailedMovie():DetailedMovie{
        val detailedMovie = arguments?.getSerializable(DETAILED_MOVIE) as DetailedMovie?
        if(detailedMovie == null){
            throw NullPointerException("Movies list cannot be null ")
        }
        return detailedMovie
    }


}
