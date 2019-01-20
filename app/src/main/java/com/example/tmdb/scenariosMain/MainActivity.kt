package com.example.tmdb.scenariosMain

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import android.widget.Toast
import com.example.tmdb.R
import com.example.tmdb.entities.DetailedMovie
import com.example.tmdb.entities.Movie
import com.example.tmdb.scenariosInDetail.DetailedActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    companion object {
        const val IN_DETAIL_VIEW = "detailedView"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showLoading()
        val presenter : MainContract.Presenter = MainPresenter(this)

        presenter.onLoadList()

    }

    override fun showList(movies: List<Movie>) {

        val adapter = TMDBAdapter(this, movies)

        adapter.setOnItemClickListener { position ->
            showLoading()

            val presenter : MainContract.Presenter = MainPresenter(this)
            presenter.onClickMovie(movies[position])

        }

        rvMovies.adapter = adapter
        rvMovies.layoutManager = LinearLayoutManager(this)
    }

    override fun listMovieInDetail(movie: DetailedMovie){
        val showInDetail = Intent(this, DetailedActivity::class.java)
        showInDetail.putExtra(IN_DETAIL_VIEW, movie)
        startActivity(showInDetail)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        pbLoading.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = ProgressBar.INVISIBLE
    }

    override fun onResume() {
        super.onResume()
        hideLoading()
    }
}