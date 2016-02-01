package pl.ghostbuster.tumblrexplorer.functional.module

import pl.ghostbuster.tumblrexplorer.functional.QuotePostHomeActivityTestCase
import pl.ghostbuster.tumblrexplorer.functional.factory.TumblrResponseFactory
import pl.ghostbuster.tumblrexplorer.usecase.api.TumblrApi
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrResponseWrapper
import rx.Observable

object TestModules {

    fun failingRetrofitProvider() = lazy {
        throw RuntimeException("Don't use internet in tests!")
    }

    fun creaeteTumblrApiWithQuotePostResponse(quoteText: String): TumblrApi {
        return object : TumblrApi {
            override fun call(baseUrl: String, startPost: Int): Observable<TumblrResponseWrapper> {
                return Observable.just(TumblrResponseFactory.createResponseWithQuotePost(quoteText))
            }
        }
    }
}