package com.example.tmdb.scenariosMain

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.example.tmdb.R
import com.example.tmdb.entities.DetailedMovie
import com.example.tmdb.entities.Movie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, MovieListFragment.OnFragmentInteractionListener{

    private var presenter : MainContract.Presenter = MainPresenter(this)

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

        val fragmentMovieList = MovieListFragment.newInstance(movies as ArrayList<Movie>)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fmMaster, fragmentMovieList)
            .commit()
    }

    override fun onFragmentInteraction(movie: Movie) {
        showLoading()
        presenter.onClickMovie(movie)
    }

    override fun listMovieInDetail(movie: DetailedMovie){
        val fragmentDetailed = DetailedMovieFragment.newInstance(movie)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fmMaster, fragmentDetailed)
            .addToBackStack(null)
            .commit()
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