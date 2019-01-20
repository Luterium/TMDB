package com.example.tmdb.scenariosInDetail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tmdb.R
import com.example.tmdb.entities.DetailedMovie
import com.example.tmdb.utils.GlideApp
import kotlinx.android.synthetic.main.activity_movie_in_detail.*

class DetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_in_detail)

        if (intent.extras != null) {
            val myData : DetailedMovie = intent.getSerializableExtra("detailedView") as DetailedMovie

            val stringBuilderTime = StringBuilder()
            val stringBuilderGenres = StringBuilder()

            val genresStrings: List<String> = myData.genres

            stringBuilderTime.append((myData.runtime.toInt()/60).toString())
            stringBuilderTime.append("h ").append((myData.runtime.toInt()%60).toString()).append("min")
            val genresIterator = genresStrings.listIterator()

            for(item in genresIterator){
                if(!item.isNullOrBlank()){
                    stringBuilderGenres.append(item).append("   ")
                }
            }

            movieDetailedName.text = myData.title
            GlideApp.with(this)
                .load(myData.poster_url)
                .placeholder(R.drawable.baseline_movie_black_48)
                .centerCrop()
                .into(movieDetailedPoster)

            movieYear.text = myData.release_date.subSequence(0,4)
            movieDuration.text = stringBuilderTime
            movieGenres.text = stringBuilderGenres
            movieDetailGrade.text = myData.vote_average
            movieOverview.text = myData.overview
        }
    }
}