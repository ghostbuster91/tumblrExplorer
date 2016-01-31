package pl.ghostbuster.tumblrexplorer.common.view

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import pl.ghostbuster.tumblrexplorer.common.extensions.inflate
import java.util.*

open class BaseRecyclerViewAdapter(val adapters: ArrayList<ItemAdapter<out RecyclerView.ViewHolder>>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = parent.inflate(viewType)
        return adapters.first { it.layout == viewType }.onCreateViewHolder(itemView)
    }

    override fun getItemCount() = adapters.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        adapters[position].onBindViewHolder(holder)
    }

    override fun getItemViewType(position: Int) = adapters[position].layout
}

