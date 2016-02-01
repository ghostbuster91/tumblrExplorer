package pl.ghostbuster.tumblrexplorer.functional.module

object TestModules {

    fun failingRetrofitProvider() = lazy {
        throw RuntimeException("Don't use internet in tests!")
    }
}