package pl.ghostbuster.tumblrexplorer.common.network

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import pl.ghostbuster.tumblrexplorer.usecase.api.TumblrPostDeserializer
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost
import retrofit2.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.RxJavaCallAdapterFactory

object TumblrRetrofitProvider {

    val testRetrofit: Retrofit? = null

    private val retrofit by lazy {
        Retrofit.Builder()
                .client(OkHttpClientProvider.client)
                .baseUrl("http://tumblr.com/api/read/")
                .addConverterFactory(GsonConverterFactory.create(
                        GsonBuilder()
                                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                                .registerTypeAdapter(TumblrPost::class.java, TumblrPostDeserializer())
                                .create()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    fun get(): Retrofit {
        return testRetrofit ?: retrofit
    }
}