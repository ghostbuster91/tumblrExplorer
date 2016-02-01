package pl.ghostbuster.tumblrexplorer.functional.extensions

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

infix fun Int.hasText(text: String) {
    onView(withId(this)).check(matches(withText(text)))
}

infix fun Int.typeText(text: String) {
    onView(withId(this)).perform(ViewActions.typeText(text))
}