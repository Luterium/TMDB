package com.example.tmdb.scenarios_main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import android.widget.Toast
import com.example.tmdb.R
import com.example.tmdb.entities.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    override fun listMovieInDetail(movie: Movie){
        /*val showInDetail = Intent(this, InDetailActivity::class.java)
        showInDetail.putExtra(IN_DETAIL_VIEW, cocktail)
        startActivity(showInDetail)*/
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