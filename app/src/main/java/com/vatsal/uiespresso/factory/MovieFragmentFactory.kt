package com.vatsal.uiespresso.factory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.vatsal.uiespresso.ui.DirectorsFragment
import com.vatsal.uiespresso.ui.MovieDetailFragment
import com.vatsal.uiespresso.ui.StarActorsFragment

class MovieFragmentFactory : FragmentFactory() {

    private val TAG = "AppDebug"

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment =

        when (className) {
            MovieDetailFragment::class.java.name -> {
                MovieDetailFragment()
            }
            DirectorsFragment::class.java.name -> {
                DirectorsFragment()
            }

            StarActorsFragment::class.java.name -> {
                StarActorsFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }

}