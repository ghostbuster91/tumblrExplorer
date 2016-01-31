package pl.ghostbuster.tumblrexplorer.extensions

import android.app.Activity
import android.support.annotation.IdRes

@Suppress("UNCHECKED_CAST")
fun <T> Activity.find(@IdRes viewId: Int): Lazy<T> {
    return lazy { findViewById(viewId) as T }
}