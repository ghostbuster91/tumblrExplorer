package pl.ghostbuster.tumblrexplorer.usecase.model

data class TumblrResponseWrapper(val postsStart: Int,
                                 val postsTotal: Int,
                                 val posts: List<TumblrPost?>)