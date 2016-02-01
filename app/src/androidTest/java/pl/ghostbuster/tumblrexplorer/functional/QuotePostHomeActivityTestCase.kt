package pl.ghostbuster.tumblrexplorer.functional

import android.support.test.espresso.intent.rule.IntentsTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import pl.ghostbuster.tumblrexplorer.R
import pl.ghostbuster.tumblrexplorer.functional.extensions.assertIsDisplayed
import pl.ghostbuster.tumblrexplorer.functional.extensions.typeText
import pl.ghostbuster.tumblrexplorer.functional.module.TestModules
import pl.ghostbuster.tumblrexplorer.functional.module.TestModulesInjector
import pl.ghostbuster.tumblrexplorer.usecase.HomeActivity
import pl.ghostbuster.tumblrexplorer.usecase.api.TumblrApi

class QuotePostHomeActivityTestCase {

    @get:Rule
    val activity = IntentsTestRule<HomeActivity>(HomeActivity::class.java)

    @Before
    fun setup() {
        TestModulesInjector.inject()
        TumblrApi.overrided = TestModules.creaeteTumblrApiWithQuotePostResponse(QUOTE_TEXT)
    }

    @Test
    fun shouldDisplayQuotePostAfterTypingInputEditText() {
        R.id.home_activity_input typeText "a"
        "\"$QUOTE_TEXT\"".assertIsDisplayed()
    }

    companion object {
        private const val QUOTE_TEXT = "quoteText"
    }
}
