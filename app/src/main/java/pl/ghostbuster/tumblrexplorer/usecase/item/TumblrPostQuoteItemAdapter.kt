package pl.ghostbuster.tumblrexplorer.usecase.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import pl.ghostbuster.tumblrexplorer.R
import pl.ghostbuster.tumblrexplorer.common.extensions.setHtml
import pl.ghostbuster.tumblrexplorer.common.view.ItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost

class TumblrPostQuoteItemAdapter(private val post: TumblrPost.QuoteTumblrPost) :
        ItemAdapter<TumblrPostQuoteItemAdapter.VH>(R.layout.tumblr_post_quote) {

    override fun onCreateViewHolder(itemView: View) = VH(itemView)

    override fun onBind(viewHolder: VH) {
        viewHolder.quoteView.setHtml(wrapWithQuotes())
        viewHolder.dateView.text = post.date
    }

    private fun wrapWithQuotes() = "&quot;${post.quoteText}&quot;"

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val quoteView = itemView.findViewById(R.id.tumblr_post_quote) as TextView
        val dateView = itemView.findViewById(R.id.tumblr_post_date) as TextView
    }
}