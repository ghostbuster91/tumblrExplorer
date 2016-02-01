package pl.ghostbuster.tumblrexplorer.usecase.item

import android.support.v7.widget.RecyclerView
import android.view.View
import pl.ghostbuster.tumblrexplorer.R
import pl.ghostbuster.tumblrexplorer.common.Bus
import pl.ghostbuster.tumblrexplorer.common.view.ItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.event.LoadMoreEvent

class LoadingItemAdapter : ItemAdapter<LoadingItemAdapter.VH>(R.layout.loading_item) {

    override fun onCreateViewHolder(itemView: View) = VH(itemView)

    override fun onBind(viewHolder: VH) {
        Bus.yell(LoadMoreEvent())
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView)
}