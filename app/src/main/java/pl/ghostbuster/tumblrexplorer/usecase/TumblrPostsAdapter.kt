package pl.ghostbuster.tumblrexplorer.usecase

import pl.ghostbuster.tumblrexplorer.common.view.BaseRecyclerViewAdapter
import pl.ghostbuster.tumblrexplorer.common.view.ItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.item.*
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost

class TumblrPostsAdapter() : BaseRecyclerViewAdapter(arrayListOf<ItemAdapter<*>>()) {

    fun setItems(posts: List<TumblrPost>) {
        val elements = posts.map(postToItemAdapter)
                .flatMap(toItemWithSeparator)
        adapters.clear()
        adapters.addAll(elements)
        notifyDataSetChanged()
    }

    private val postToItemAdapter = { post: TumblrPost ->
        when (post) {
            is TumblrPost.QuoteTumblrPost -> TumblrPostQuoteItemAdapter(post)
            is TumblrPost.RegulerTumblrPost -> TumblrPostRegularItemAdapter(post)
            is TumblrPost.PhotoTumblrPost -> TumblrPostPhotoItemAdapter(post)
            is TumblrPost.VideoTumblrPost -> TumblrPostVideoItemAdapter(post)
            is TumblrPost.LinkTumblrPost -> TumblrPostLinkItemAdapter(post)
            else -> {
                throw RuntimeException()
            }
        }
    }

    private val toItemWithSeparator = { item: ItemAdapter<*> ->
        listOf(item, SeparatorItemAdapter())
    }
}