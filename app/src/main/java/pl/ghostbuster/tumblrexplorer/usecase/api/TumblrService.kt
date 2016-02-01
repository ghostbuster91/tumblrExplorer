package pl.ghostbuster.tumblrexplorer.usecase.api

import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrResponseWrapper
import rx.Observable

class TumblrService(val tumblrApi: TumblrApi) {

    fun call(userName: String, startPost: Int): Observable<TumblrResponseWrapper> {
        return tumblrApi.call(url.replace("{userName}", userName), startPost)
    }

    companion object {
        private const val url = "http://{userName}.tumblr.com/api/read/json"
    }
}