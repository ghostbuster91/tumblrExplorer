package pl.ghostbuster.tumblrexplorer.common.network

import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.Response
import okhttp3.ResponseBody

class TumblrResponseFixingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val body = response.body().string()
        val notMalformedBody = body.removePrefix("var tumblr_api_read = ")
        return response.newBuilder()
                .body(ResponseBody.create(MediaType.parse("Content-Type"), notMalformedBody))
                .build()
    }
}