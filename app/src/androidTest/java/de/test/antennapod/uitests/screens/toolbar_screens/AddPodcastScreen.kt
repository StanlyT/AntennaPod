package de.test.antennapod.uitests.screens.toolbar_screens

import de.danoeh.antennapod.R
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView

object AddPodcastScreen : BaseToolbarScreen<AddPodcastScreen>() {

    val screenTitle = KTextView {
        withParent { withId(R.id.toolbar) }
        withText("Add Podcast")
    }

    val searchEditText = KEditText {
        withId(R.id.combinedFeedSearchEditText)
    }

    val searchButton = KImageView {
        withId(R.id.searchButton)
    }

    override fun isScreenDisplayed() {
        screenTitle.isDisplayed()
    }
}