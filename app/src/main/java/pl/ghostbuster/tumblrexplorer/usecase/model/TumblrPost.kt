package pl.ghostbuster.tumblrexplorer.usecase.model

import com.google.gson.annotations.SerializedName

sealed class TumblrPost(val id: String, val date: String) {

    class QuoteTumblrPost(id: String,
                          date: String,
                          val quoteText: String) : TumblrPost(id, date)

    class RegulerTumblrPost(id: String,
                            date: String,
                            val regularTitle: String,
                            val regularBody: String) : TumblrPost(id, date)

    class PhotoTumblrPost(id: String,
                          date: String,
                          val photoCaption: String,
                          @SerializedName("photo-url-250") val photoUrl: String) : TumblrPost(id, date)

    class VideoTumblrPost(id: String,
                          date: String,
                          val videoCaption: String,
                          val videoSource: String) : TumblrPost(id, date)

    class LinkTumblrPost(id: String,
                         date: String,
                         val linkText: String,
                         val linkUrl: String,
                         val linkDescritpion: String?) : TumblrPost(id, date)
}