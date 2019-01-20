package com.example.tmdb.scenariosMain


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.tmdb.R
import com.example.tmdb.entities.Movie
import kotlinx.android.synthetic.main.fragment_movie_list.*
import java.lang.NullPointerException
import java.lang.RuntimeException

class MovieListFragment : Fragment() {

    companion object {
        private val MOVIE_LIST = "movie_list"
        fun newInstance(movieList: ArrayList<Movie>) =
            MovieListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MOVIE_LIST, movieList)
                }
            }
    }

    var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movies = getMovieList()

        // O Fragment é capaz de mapear a activity que está o instanciando
        activity?.let{ that ->
            val adapter = TMDBAdapter(that, movies)

            adapter.setOnItemClickListener { position ->
                listener?.onFragmentInteraction(movies[position])
            }

            rvMovies.adapter = adapter
            rvMovies.layoutManager = LinearLayoutManager(that)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is MovieListFragment.OnFragmentInteractionListener) {
            listener = context
        }else{
            throw RuntimeException(context.toString() + "must implement MovieListFragment.OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun getMovieList():ArrayList<Movie>{
        val movies = arguments?.getSerializable(MOVIE_LIST) as ArrayList<Movie>?
        if(movies == null){
            throw NullPointerException("Movies list cannot be null ")
        }

        return movies
    }

    interface OnFragmentInteractionListener{
        fun onFragmentInteraction(movie: Movie)
    }

}
