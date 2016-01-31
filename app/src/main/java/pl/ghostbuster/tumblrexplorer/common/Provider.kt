package pl.ghostbuster.tumblrexplorer.common

abstract class Provider<T>(initializer: () -> T) {
    var overrided: T? = null

    private val original by lazy(LazyThreadSafetyMode.NONE, initializer)

    fun get() = overrided ?: original
}