package de.test.antennapod.uitests.screens

import de.danoeh.antennapod.R
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object PodcastContainerScreen : BaseScreen<PodcastContainerScreen>() {

    val displayContainer = KView {
        withId(R.id.feed_display_container)
    }

    val subscribeButton = KButton {
        withId(R.id.subscribeButton)
    }

    val titleLabel = KTextView {
        withId(R.id.titleLabel)
    }

    override fun isScreenDisplayed() {
        displayContainer.isDisplayed()
    }
}