package com.vatsal.uiespresso.ui

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.vatsal.uiespresso.factory.MovieFragmentFactory
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.vatsal.uiespresso.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DirectorsFragmentTest{

    @Test
    fun test_isDirector_list_displayed(){
        val directors =  arrayListOf("R.J. Stewart", "James Vanderbilt")
        val factory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_directors",directors)

        val scenario = launchFragmentInContainer<DirectorsFragment>(
                bundle,
                factory = factory
        )
        onView(withId(R.id.directors_text))
                .check(matches(withText(DirectorsFragment.stringBuilderForDirectors(directors))))

    }
}