package com.vatsal.uiespresso.data.source

import com.vatsal.uiespresso.data.DummyMovies
import com.vatsal.uiespresso.data.Movie

object MoviesRemoteDataSource : MoviesDataSource {

    private var MOVIES_REMOTE_DATA = LinkedHashMap<Int,Movie>()
    init {
        addMovie(DummyMovies.INFINITY_WAR)
        addMovie(DummyMovies.THE_RUNDOWN)
    }
    override fun getMovie(movieId: Int): Movie? {
        return MOVIES_REMOTE_DATA[movieId]
    }

    private fun addMovie(movie: Movie){
        MOVIES_REMOTE_DATA[movie.id] = movie
    }
}
