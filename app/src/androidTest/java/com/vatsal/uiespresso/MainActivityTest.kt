package com.vatsal.uiespresso

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Test
    fun test_isActivityInView(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_title_next_button() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //title
        onView(withId(R.id.activity_main_title))
            .check(matches(isDisplayed()))

        // next button
        onView(withId(R.id.button_next_activity))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

    }

    @Test
    fun test_isTitle_text_displayed() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.activity_main_title))
            .check(matches(withText(R.string.text_mainactivity)))
    }

    @Test
    fun test_nav_to_second_activity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Click on next button
        onView(withId(R.id.button_next_activity))
            .perform(click())

        // check second activity launch by checking view of the second activity layout.
        onView(withId(R.id.secondary))
            .check(matches(isDisplayed()))
    }


    @Test
    fun test_nav_back_to_main_activity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // Click on next button
        onView(withId(R.id.button_next_activity))
            .perform(click())

        // check second activity launch by checking view of the second activity layout.
        onView(withId(R.id.secondary))
            .check(matches(isDisplayed()))

      /*  onView(withId(R.id.button_back))
            .perform(click()) // method 1*/

        pressBack()  // method 2

        // Check we are back on main activity.
        onView(withId(R.id.main))
            .check(matches(isDisplayed()))
    }
}