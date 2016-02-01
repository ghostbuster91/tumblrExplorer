package pl.ghostbuster.tumblrexplorer.usecase.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import pl.ghostbuster.tumblrexplorer.R
import pl.ghostbuster.tumblrexplorer.common.extensions.setHtml
import pl.ghostbuster.tumblrexplorer.common.extensions.setVisibility
import pl.ghostbuster.tumblrexplorer.common.view.ItemAdapter
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost

class TumblrPostPhotoItemAdapter(private val post: TumblrPost.PhotoTumblrPost) :
        ItemAdapter<TumblrPostPhotoItemAdapter.VH>(R.layout.tumblr_post_photo) {

    override fun onCreateViewHolder(itemView: View) = VH(itemView)

    override fun onBind(viewHolder: VH) {
        Glide.with(viewHolder.itemView.context).load(post.photoUrl).into(viewHolder.imageView)
        viewHolder.titleView.setVisibility(post.photoCaption.isNotEmpty())
        viewHolder.titleView.setHtml(post.photoCaption)
        viewHolder.dateView.text = post.date
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById(R.id.tumblr_post_photo_image) as ImageView
        val titleView = itemView.findViewById(R.id.tumblr_post_photo_title) as TextView
        val dateView = itemView.findViewById(R.id.tumblr_post_date) as TextView
    }
}