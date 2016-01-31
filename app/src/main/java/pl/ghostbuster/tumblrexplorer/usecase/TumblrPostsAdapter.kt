package pl.ghostbuster.tumblrexplorer.usecase

import pl.ghostbuster.tumblrexplorer.common.view.BaseRecyclerViewAdapter
import pl.ghostbuster.tumblrexplorer.common.view.ItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.item.*
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost

class TumblrPostsAdapter() : BaseRecyclerViewAdapter(arrayListOf<ItemAdapter<*>>()) {

    fun setItems(posts: List<TumblrPost>) {
        adapters.clear()
        adapters.addAll(posts.filter(isTypeSupported)
                .map(postToItemAdapter)
                .map(toItemWithSeparator)
                .flatten())
        notifyDataSetChanged()
    }

    //TODO: remove when all types will be supported
    private val isTypeSupported = { post: TumblrPost ->
        post is TumblrPost.QuoteTumblrPost
                || post is TumblrPost.RegulerTumblrPost
                || post is TumblrPost.PhotoTumblrPost
                || post is TumblrPost.VideoTumblrPost
    }

    private val postToItemAdapter = { post: TumblrPost ->
        when (post) {
            is TumblrPost.QuoteTumblrPost -> TumblrPostQuoteItemAdapter(post)
            is TumblrPost.RegulerTumblrPost -> TumblrPostRegularItemAdapter(post)
            is TumblrPost.PhotoTumblrPost -> TumblrPostPhotoItemAdapter(post)
            is TumblrPost.VideoTumblrPost -> TumblrPostVideoItemAdapter(post)
            else -> {
                throw RuntimeException()
            }
        }
    }

    private val toItemWithSeparator = { item: ItemAdapter<*> ->
        listOf(item, SeparatorItemAdapter())
    }
}