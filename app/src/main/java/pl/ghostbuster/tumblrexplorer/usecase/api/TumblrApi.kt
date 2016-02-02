package pl.ghostbuster.tumblrexplorer.usecase.api

import pl.ghostbuster.tumblrexplorer.common.Provider
import pl.ghostbuster.tumblrexplorer.common.network.TumblrRetrofitProvider
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import rx.Single

interface TumblrApi {

    @GET
    fun call(@Url baseUrl: String, @Query("start") startPost: Int): Single<TumblrResponseWrapper>

    companion object : Provider<TumblrApi>({ TumblrRetrofitProvider.get().create(TumblrApi::class.java) })
}