package pl.ghostbuster.tumblrexplorer.common.extensions

import android.text.Html
import android.widget.TextView

fun TextView.setHtml(textToSet: String) {
    text = Html.fromHtml(textToSet)
}