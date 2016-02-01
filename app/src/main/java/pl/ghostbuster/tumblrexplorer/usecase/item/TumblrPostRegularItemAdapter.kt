package pl.ghostbuster.tumblrexplorer.usecase.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import pl.ghostbuster.tumblrexplorer.R
import pl.ghostbuster.tumblrexplorer.common.extensions.setHtml
import pl.ghostbuster.tumblrexplorer.common.extensions.setVisibility
import pl.ghostbuster.tumblrexplorer.common.view.ItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost

class TumblrPostRegularItemAdapter(private val post: TumblrPost.RegulerTumblrPost) :
        ItemAdapter<TumblrPostRegularItemAdapter.VH>(R.layout.tumblr_post_regular) {

    override fun onCreateViewHolder(itemView: View) = VH(itemView)

    override fun onBind(viewHolder: TumblrPostRegularItemAdapter.VH) {
        if (post.regularTitle != null) {
            viewHolder.titleView.setHtml(post.regularTitle)
        }
        viewHolder.bodyView.setVisibility(post.regularBody.isNotEmpty())
        viewHolder.bodyView.setHtml(post.regularBody)
        viewHolder.dateView.text = post.date
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView = itemView.findViewById(R.id.tumblr_post_regular_title) as TextView
        val bodyView = itemView.findViewById(R.id.tumblr_post_regular_body) as TextView
        val dateView = itemView.findViewById(R.id.tumblr_post_date) as TextView
    }
}