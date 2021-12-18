package de.test.antennapod.uitests.screens.toolbar_screens

import de.test.antennapod.uitests.screens.BaseScreen
import io.github.kakaocup.kakao.image.KImageView

abstract class BaseToolbarScreen<out T : BaseToolbarScreen<T>> : BaseScreen<T>() {
    val toolbarMenu = KImageView {
        withText("Open menu")
    }
}