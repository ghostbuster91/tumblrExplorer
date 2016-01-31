package pl.ghostbuster.tumblrexplorer.usecase

import pl.ghostbuster.tumblrexplorer.common.view.BaseRecyclerViewAdapter
import pl.ghostbuster.tumblrexplorer.common.view.ItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.item.SeparatorItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.item.TumblrPostQuoteItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.item.TumblrPostRegularItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost

class TumblrPostsAdapter() : BaseRecyclerViewAdapter(arrayListOf<ItemAdapter<*>>()) {

    fun setItems(posts: List<TumblrPost>) {
        adapters.clear()
        adapters.addAll(posts.filter { it is TumblrPost.QuoteTumblrPost || it is TumblrPost.RegulerTumblrPost }
                .map(postToItemAdapter)
                .map(toItemWithSeparator)
                .flatten())
        notifyDataSetChanged()
    }

    private val postToItemAdapter = { post: TumblrPost ->
        when (post) {
            is TumblrPost.QuoteTumblrPost -> TumblrPostQuoteItemAdapter(post)
            is TumblrPost.RegulerTumblrPost -> TumblrPostRegularItemAdapter(post)
            else -> {
                throw RuntimeException()
            }
        }
    }

    private val toItemWithSeparator = { item: ItemAdapter<*> ->
        listOf(item, SeparatorItemAdapter())
    }
}