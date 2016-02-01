package pl.ghostbuster.tumblrexplorer.usecase.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import pl.ghostbuster.tumblrexplorer.R
import pl.ghostbuster.tumblrexplorer.common.Bus
import pl.ghostbuster.tumblrexplorer.common.extensions.setHtml
import pl.ghostbuster.tumblrexplorer.common.view.ItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.event.OnLinkClickEvent
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost

class TumblrPostLinkItemAdapter(private val post: TumblrPost.LinkTumblrPost) :
        ItemAdapter<TumblrPostLinkItemAdapter.VH>(R.layout.tumblr_post_link) {

    override fun onCreateViewHolder(itemView: View) = VH(itemView)

    override fun onBind(viewHolder: TumblrPostLinkItemAdapter.VH) {
        viewHolder.linkTextView.setHtml(post.linkText)
        bindLinkDescription(viewHolder)
        viewHolder.dateView.text = post.date
        viewHolder.itemView.setOnClickListener {
            Bus.yell(OnLinkClickEvent(post.linkUrl))
        }
    }

    private fun bindLinkDescription(viewHolder: VH) {
        if (post.linkDescritpion != null && post.linkDescritpion.isNotEmpty()) {
            viewHolder.linkDescView.visibility = View.VISIBLE
            viewHolder.linkDescView.setHtml(post.linkDescritpion)
        } else {
            viewHolder.linkDescView.visibility = View.INVISIBLE
        }
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val linkTextView = itemView.findViewById(R.id.tumblr_post_link_text) as TextView
        val linkDescView = itemView.findViewById(R.id.tumblr_post_link_description) as TextView
        val dateView = itemView.findViewById(R.id.tumblr_post_date) as TextView
    }
}