package pl.ghostbuster.tumblrexplorer.functional.module

import pl.ghostbuster.tumblrexplorer.common.network.TumblrRetrofitProvider

object TestModulesInjector {
    fun inject() {
        TumblrRetrofitProvider.testRetrofit = TestModules.failingRetrofitProvider()
    }
}