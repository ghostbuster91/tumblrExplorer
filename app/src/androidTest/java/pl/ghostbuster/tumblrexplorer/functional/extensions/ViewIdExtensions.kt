package pl.ghostbuster.tumblrexplorer.functional.extensions

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import pl.ghostbuster.tumblrexplorer.R

infix fun Int.hasText(text: String) {
    onView(withId(R.id.home_activity_input)).check(matches(withText(text)))
}

infix fun Int.typeText(text: String) {
    onView(withId(R.id.home_activity_input)).perform(ViewActions.typeText(text))
}