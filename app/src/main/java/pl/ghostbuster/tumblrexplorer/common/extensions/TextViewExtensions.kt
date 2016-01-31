package pl.ghostbuster.tumblrexplorer.common.extensions

import android.text.Html
import android.text.method.LinkMovementMethod
import android.widget.TextView

fun TextView.setHtml(textToSet: String) {
    text = Html.fromHtml(textToSet)
    movementMethod = LinkMovementMethod.getInstance()
}