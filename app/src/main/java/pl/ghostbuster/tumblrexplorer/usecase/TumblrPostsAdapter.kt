package pl.ghostbuster.tumblrexplorer.usecase

import pl.ghostbuster.tumblrexplorer.common.view.BaseRecyclerViewAdapter
import pl.ghostbuster.tumblrexplorer.common.view.ItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.item.*
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrResponseWrapper

class TumblrPostsAdapter() : BaseRecyclerViewAdapter(arrayListOf<ItemAdapter<*>>()) {

    fun setItems(response: TumblrResponseWrapper) {
        adapters.clear()
        addItemsImpl(response)
    }

    fun appendItems(response: TumblrResponseWrapper) {
        adapters.removeAt(adapters.lastIndex)
        addItemsImpl(response)
    }

    private fun addItemsImpl(response: TumblrResponseWrapper) {
        adapters.addAll(mapPostsToItems(response))
        if (isNotAllDataLoaded(response)) {
            adapters.add(LoadingItemAdapter())
        }
        notifyDataSetChanged()
    }

    private fun isNotAllDataLoaded(tumblrResponse: TumblrResponseWrapper): Boolean {
        return tumblrResponse.postsStart + tumblrResponse.posts.size < tumblrResponse.postsTotal
    }

    private fun mapPostsToItems(tumblrResponse: TumblrResponseWrapper) = tumblrResponse.posts
            .filter { it != null }
            .map { postToItemAdapter(it!!) }
            .flatMap(toItemWithSeparator)

    private fun postToItemAdapter(post: TumblrPost): ItemAdapter<*> {
        return when (post) {
            is TumblrPost.QuoteTumblrPost -> TumblrPostQuoteItemAdapter(post)
            is TumblrPost.RegulerTumblrPost -> TumblrPostRegularItemAdapter(post)
            is TumblrPost.PhotoTumblrPost -> TumblrPostPhotoItemAdapter(post)
            is TumblrPost.VideoTumblrPost -> TumblrPostVideoItemAdapter(post)
            is TumblrPost.LinkTumblrPost -> TumblrPostLinkItemAdapter(post)
        }
    }

    private val toItemWithSeparator = { item: ItemAdapter<*> ->
        listOf(item, SeparatorItemAdapter())
    }
}