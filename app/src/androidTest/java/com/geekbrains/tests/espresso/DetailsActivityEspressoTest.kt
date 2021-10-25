package com.geekbrains.tests.espresso

import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.geekbrains.tests.*
import com.geekbrains.tests.view.details.DetailsActivity
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailsActivityEspressoTest {

    private lateinit var scenario: ActivityScenario<DetailsActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(DetailsActivity::class.java)
    }

    @Test
    fun activity_AssertNotNull() {
        scenario.onActivity {
            TestCase.assertNotNull(it)
        }
    }

    @Test
    fun activity_IsResumed() {
        TestCase.assertEquals(Lifecycle.State.RESUMED, scenario.state)
    }

    @Test
    fun activityTextView_NotNull() {
        scenario.onActivity {
            val totalCountTextView = it.findViewById<TextView>(TOTAL_COUNT_ID)
            TestCase.assertNotNull(totalCountTextView)
        }
    }

    @Test
    fun activityTextView_HasText() {
        onViewMatches(TOTAL_COUNT_ID) { withText(TEST_NUMBER_OF_RESULTS_ZERO) }
    }

    @Test
    fun activityTextView_IsDisplayed() {
        onViewMatches(TOTAL_COUNT_ID) { isDisplayed() }
    }

    @Test
    fun activityTextView_IsCompletelyDisplayed() {
        onViewMatches(TOTAL_COUNT_ID) { isCompletelyDisplayed() }
    }

    @Test
    fun activityButtons_AreEffectiveVisible() {
        onViewMatches(R.id.incrementButton) { withEffectiveVisibility(Visibility.VISIBLE) }
        onViewMatches(R.id.decrementButton) { withEffectiveVisibility(Visibility.VISIBLE) }
    }

    @Test
    fun activityButtonIncrement_IsWorking() {
        clickOnView(R.id.incrementButton)
        onViewMatches(TOTAL_COUNT_ID) { withText(TEST_NUMBER_OF_RESULTS_PLUS_1) }
    }

    @Test
    fun activityButtonDecrement_IsWorking() {
        clickOnView(R.id.decrementButton)
        onViewMatches(TOTAL_COUNT_ID) { withText(TEST_NUMBER_OF_RESULTS_MINUS_1) }
    }

    @After
    fun close() {
        scenario.close()
    }
}
