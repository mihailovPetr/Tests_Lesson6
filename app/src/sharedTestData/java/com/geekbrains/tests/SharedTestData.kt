package com.geekbrains.tests

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.Matcher

internal const val TEST_NUMBER = 42
internal const val TEST_NUMBER_OF_RESULTS_ZERO = "Number of results: 0"
internal const val TEST_NUMBER_OF_RESULTS_PLUS_1 = "Number of results: 1"
internal const val TEST_NUMBER_OF_RESULTS_MINUS_1 = "Number of results: -1"

internal const val SEARCH_EDIT_ID = R.id.searchEditText
internal const val TOTAL_COUNT_ID = R.id.totalCountTextView
internal const val TO_DETAILS_ID = R.id.toDetailsActivityButton

fun clickOnView(id: Int) = onView(withId(id)).perform(ViewActions.click())

fun onViewMatches(id: Int, matcher: () -> Matcher<View>) =
    onView(withId(id)).check(matches(matcher()))
