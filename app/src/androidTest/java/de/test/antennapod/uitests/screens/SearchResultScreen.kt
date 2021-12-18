package de.test.antennapod.uitests.screens

import androidx.test.espresso.DataInteraction
import de.danoeh.antennapod.R
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.list.KAbsListView
import io.github.kakaocup.kakao.list.KAdapterItem
import io.github.kakaocup.kakao.text.KTextView

object SearchResultScreen : BaseScreen<SearchResultScreen>() {

    val searchSrcEditText = KEditText {
        withId(R.id.search_src_text)
    }

    val searchResultList = KAbsListView(
        builder = { withId(R.id.gridView) },
        itemTypeBuilder = { itemType(::ResultItem) }
    )

    class ResultItem(i: DataInteraction) : KAdapterItem<ResultItem>(i) {
        val txtTitle = KTextView(i) { withId(R.id.txtvTitle) }
        val txtAuthor = KTextView(i) { withId(R.id.txtvAuthor) }
    }

    override fun isScreenDisplayed() {
        searchSrcEditText.isDisplayed()
    }
}