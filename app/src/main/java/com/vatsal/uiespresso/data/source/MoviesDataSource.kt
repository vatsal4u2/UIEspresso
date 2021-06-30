package com.vatsal.uiespresso.data.source

import com.vatsal.uiespresso.data.Movie

interface MoviesDataSource {

    fun getMovie(movieId : Int) : Movie?
}