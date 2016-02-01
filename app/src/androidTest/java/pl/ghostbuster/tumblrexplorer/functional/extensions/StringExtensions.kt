package pl.ghostbuster.tumblrexplorer.functional.extensions

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText

fun String.assertIsDisplayed() {
    onView(withText(this)).check(matches(isDisplayed()))
}