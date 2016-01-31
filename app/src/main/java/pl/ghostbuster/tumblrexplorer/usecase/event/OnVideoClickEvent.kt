package pl.ghostbuster.tumblrexplorer.usecase.event

import pl.ghostbuster.tumblrexplorer.common.Bus

data class OnVideoClickEvent(val url: String) : Bus.Event