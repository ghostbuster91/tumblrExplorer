package pl.ghostbuster.tumblrexplorer.usecase.api

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import pl.ghostbuster.tumblrexplorer.usecase.model.TumblrPost
import java.lang.reflect.Type

class TumblrPostDeserializer : JsonDeserializer<TumblrPost> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): TumblrPost {
        val postType = json.asJsonObject.get("type").asString
        return when (postType) {
            "photo" -> context.deserialize(json, TumblrPost.PhotoTumblrPost::class.java)
            "video" -> context.deserialize(json, TumblrPost.VideoTumblrPost::class.java)
            "link" -> context.deserialize(json, TumblrPost.LinkTumblrPost::class.java)
            "quote" -> context.deserialize(json, TumblrPost.QuoteTumblrPost::class.java)
            "regular" -> context.deserialize(json, TumblrPost.RegulerTumblrPost::class.java)
            else -> context.deserialize(json, TumblrPost.UnknownType::class.java)
        }
    }
}