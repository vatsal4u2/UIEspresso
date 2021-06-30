package com.vatsal.uiespresso.ui

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.vatsal.uiespresso.R
import com.vatsal.uiespresso.data.DummyMovies.THE_RUNDOWN
import com.vatsal.uiespresso.factory.MovieFragmentFactory
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MovieDetailFragmentTest{

    @Test
    fun test_isMovieDetail_Displayed() {
        val movie = THE_RUNDOWN
        val factory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putInt("movie_id", movie.id)

        val scenario = launchFragmentInContainer<MovieDetailFragment>(
                fragmentArgs = bundle,
                factory = factory
        )
        // movie title
        onView(withId(R.id.movie_title))
                .check(matches(withText(movie.title)))

        // movie description
        onView(withId(R.id.movie_description))
                .check(matches(withText(movie.description)))
    }


}