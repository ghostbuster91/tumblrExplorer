package pl.ghostbuster.tumblrexplorer.unit

import android.support.test.runner.AndroidJUnit4
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import pl.ghostbuster.tumblrexplorer.usecase.api.TumblrPostDeserializer
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrResponseWrapper


@RunWith(AndroidJUnit4::class)
class TumblrPostDeserializerTestCase {

    private val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
            .registerTypeAdapter(TumblrPost::class.java, TumblrPostDeserializer())
            .create()

    @Test
    fun shouldDeserializeJsonToTumblrResponseWrapper() {
        val fromJson = gson.fromJson("""
        {
              "posts-start": 0,
              "posts-total": 7,
              "posts": []
        }""", TumblrResponseWrapper::class.java)

        val expected = TumblrResponseWrapper(postsStart = 0,
                postsTotal = 7,
                posts = emptyList())

        Assert.assertEquals(expected, fromJson)
    }

    @Test
    fun shouldDeserializeJsonWithTypeQuoteToTumblrPostQuote() {
        val fromJson = createTumblrQuotePost("""
        {
              "posts-start": 0,
              "posts-total": 7,
              "posts": [
                {
                  "id": "1",
                  "type": "quote",
                  "date": "date",
                  "quote-text": "textText"
                }
              ]
        }""")

        val expected = TumblrPost.QuoteTumblrPost(id = "1",
                date = "date",
                quoteText = "textText")

        Assert.assertEquals(expected.id, fromJson.id)
        Assert.assertEquals(expected.date, fromJson.date)
        Assert.assertEquals(expected.quoteText, fromJson.quoteText)
    }

    private fun createTumblrQuotePost(json: String): TumblrPost.QuoteTumblrPost {
        return gson.fromJson(json, TumblrResponseWrapper::class.java).posts.first() as TumblrPost.QuoteTumblrPost
    }
}