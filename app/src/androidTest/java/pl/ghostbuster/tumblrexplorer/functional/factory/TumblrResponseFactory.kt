package pl.ghostbuster.tumblrexplorer.functional.factory

import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrResponseWrapper

object TumblrResponseFactory {

    fun createResponseWithQuotePost(quoteText: String) = TumblrResponseWrapper(
            postsStart = 0,
            postsTotal = 1,
            posts = listOf(TumblrPost.QuoteTumblrPost(
                    id = "1",
                    date = "date",
                    quoteText = quoteText
            )))
}
