package pl.ghostbuster.tumblrexplorer.usecase.item

import android.support.v7.widget.RecyclerView
import android.view.View
import pl.ghostbuster.tumblrexplorer.R
import pl.ghostbuster.tumblrexplorer.common.view.ItemAdapter

class SeparatorItemAdapter : ItemAdapter<SeparatorItemAdapter.SeparatorItemHolder>(R.layout.separator_item) {

    override fun onCreateViewHolder(itemView: View): SeparatorItemHolder {
        return SeparatorItemHolder(itemView)
    }

    override fun onBind(viewHolder: SeparatorItemHolder) {
    }

    class SeparatorItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}