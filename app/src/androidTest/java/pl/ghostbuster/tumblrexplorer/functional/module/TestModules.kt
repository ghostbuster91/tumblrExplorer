package pl.ghostbuster.tumblrexplorer.functional.module

import pl.ghostbuster.tumblrexplorer.functional.factory.TumblrResponseFactory
import pl.ghostbuster.tumblrexplorer.usecase.api.TumblrApi
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrResponseWrapper
import rx.Observable
import rx.Single

object TestModules {

    fun failingRetrofitProvider() = lazy {
        throw RuntimeException("Don't use internet in tests!")
    }

    fun creaeteTumblrApiWithQuotePostResponse(quoteText: String): TumblrApi {
        return object : TumblrApi {
            override fun call(baseUrl: String, startPost: Int): Single<TumblrResponseWrapper> {
                return Single.just(TumblrResponseFactory.createResponseWithQuotePost(quoteText))
            }
        }
    }
}