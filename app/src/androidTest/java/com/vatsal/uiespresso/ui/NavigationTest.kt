package com.vatsal.uiespresso.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.vatsal.uiespresso.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class NavigationTest {

    @get:Rule
    val activityRule  = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_movie_fragment_navigation(){
        // When Activity launch, It will create movieDetail fragment.
        onView(withId(R.id.movie_directiors))
                .perform(click())

        // verify director fragment is launched
        onView(withId(R.id.director_fragment_container))
                .check(matches(isDisplayed()))

        pressBack()

        // Verify we are back on the movie detail fragment.
        onView(withId(R.id.movie_detail_fragment_container))
                .check(matches(isDisplayed()))

    }
}