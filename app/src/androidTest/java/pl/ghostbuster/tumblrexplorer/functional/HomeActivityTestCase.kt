package pl.ghostbuster.tumblrexplorer.functional

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import pl.ghostbuster.tumblrexplorer.R
import pl.ghostbuster.tumblrexplorer.usecase.HomeActivity

@RunWith(AndroidJUnit4::class)
class HomeActivityTestCase {

    @get:Rule
    val activity = IntentsTestRule<HomeActivity>(HomeActivity::class.java)

    @Test
    fun testShouldDisplayEmptyInputEditText() {
        onView(withId(R.id.home_activity_input)).check(matches(withText("")))
    }
}