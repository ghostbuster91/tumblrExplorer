package pl.ghostbuster.tumblrexplorer.common.view

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View

abstract class ItemAdapter<VH : RecyclerView.ViewHolder>(@LayoutRes val layout: Int) {

    abstract fun onCreateViewHolder(itemView: View): VH

    @Suppress("UNCHECKED_CAST")
    fun onBindViewHolder(holder: RecyclerView.ViewHolder) {
        onBind(holder as VH)
    }

    abstract fun onBind(viewHolder: VH)
}