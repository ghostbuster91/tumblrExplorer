package pl.ghostbuster.tumblrexplorer.usecase.event

import pl.ghostbuster.tumblrexplorer.common.Bus

data class OnLinkClickEvent(val linkUrl: String) : Bus.Event
