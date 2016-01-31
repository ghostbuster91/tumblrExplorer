package pl.ghostbuster.tumblrexplorer.usecase.item

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import pl.ghostbuster.tumblrexplorer.R
import pl.ghostbuster.tumblrexplorer.common.extensions.setHtml
import pl.ghostbuster.tumblrexplorer.common.view.ItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost

class TumblrPostVideoItemAdapter(private val post: TumblrPost.VideoTumblrPost) :
        ItemAdapter<TumblrPostVideoItemAdapter.VH>(R.layout.tumblr_post_video) {

    override fun onCreateViewHolder(itemView: View) = VH(itemView)

    override fun onBind(viewHolder: VH) {
        viewHolder.captionView.setHtml(post.videoCaption)
        viewHolder.itemView.setOnClickListener {
            startVideoInYoutube(viewHolder.itemView.context)
        }
        viewHolder.dateView.text = post.date
    }

    private fun startVideoInYoutube(context: Context) {
        val videoUrl = post.videoSource.substringAfter("value=\"").substringBefore("\">")
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl)))
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val captionView = itemView.findViewById(R.id.tumblr_post_video_title) as TextView
        val dateView = itemView.findViewById(R.id.tumblr_post_date) as TextView
    }
}