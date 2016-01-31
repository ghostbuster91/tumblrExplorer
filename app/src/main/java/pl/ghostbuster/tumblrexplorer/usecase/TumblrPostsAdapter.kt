package pl.ghostbuster.tumblrexplorer.usecase

import pl.ghostbuster.tumblrexplorer.common.view.BaseRecyclerViewAdapter
import pl.ghostbuster.tumblrexplorer.common.view.ItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.item.SeparatorItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.item.TumblrPostPhotoItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.item.TumblrPostQuoteItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.item.TumblrPostRegularItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost

class TumblrPostsAdapter() : BaseRecyclerViewAdapter(arrayListOf<ItemAdapter<*>>()) {

    fun setItems(posts: List<TumblrPost>) {
        adapters.clear()
        adapters.addAll(posts.filter(isAlreadySupported)
                .map(postToItemAdapter)
                .map(toItemWithSeparator)
                .flatten())
        notifyDataSetChanged()
    }

    //TODO: remove when all types will be supported
    private val isAlreadySupported = { post: TumblrPost ->
        post is TumblrPost.QuoteTumblrPost
                || post is TumblrPost.RegulerTumblrPost
                || post is TumblrPost.PhotoTumblrPost
    }

    private val postToItemAdapter = { post: TumblrPost ->
        when (post) {
            is TumblrPost.QuoteTumblrPost -> TumblrPostQuoteItemAdapter(post)
            is TumblrPost.RegulerTumblrPost -> TumblrPostRegularItemAdapter(post)
            is TumblrPost.PhotoTumblrPost -> TumblrPostPhotoItemAdapter(post)
            else -> {
                throw RuntimeException()
            }
        }
    }

    private val toItemWithSeparator = { item: ItemAdapter<*> ->
        listOf(item, SeparatorItemAdapter())
    }
}