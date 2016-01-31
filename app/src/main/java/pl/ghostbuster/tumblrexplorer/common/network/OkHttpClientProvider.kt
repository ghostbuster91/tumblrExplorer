package pl.ghostbuster.tumblrexplorer.common.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object OkHttpClientProvider {

    val client by lazy {
        OkHttpClient.Builder()
                .addInterceptor(
                        HttpLoggingInterceptor()
                                .apply { setLevel(HttpLoggingInterceptor.Level.BODY) })
                .addInterceptor(TumblrResponseFixingInterceptor())
                .build()
    }
}