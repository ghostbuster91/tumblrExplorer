package pl.ghostbuster.tumblrexplorer.functional

import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import pl.ghostbuster.tumblrexplorer.R
import pl.ghostbuster.tumblrexplorer.functional.extensions.hasText
import pl.ghostbuster.tumblrexplorer.functional.extensions.typeText
import pl.ghostbuster.tumblrexplorer.functional.module.TestModulesInjector
import pl.ghostbuster.tumblrexplorer.usecase.HomeActivity

@RunWith(AndroidJUnit4::class)
class InitialHomeActivityTestCase {

    @get:Rule
    val activity = IntentsTestRule<HomeActivity>(HomeActivity::class.java)

    @Before
    fun setup() {
        TestModulesInjector.inject()
    }

    @Test
    fun shouldDisplayEmptyInputEditText() {
        R.id.home_activity_input hasText ""
    }
}