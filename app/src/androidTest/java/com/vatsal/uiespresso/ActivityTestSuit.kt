package com.vatsal.uiespresso

import org.junit.runner.RunWith
import org.junit.runners.Suite


// This class is used to run your activities test together.
@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    SecondActivityTest::class
)
class ActivityTestSuit