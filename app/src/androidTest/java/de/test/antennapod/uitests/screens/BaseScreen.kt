package de.test.antennapod.uitests.screens

import io.github.kakaocup.kakao.screen.Screen

abstract class BaseScreen<out T : BaseScreen<T>> : Screen<T>() {
    abstract fun isScreenDisplayed()
}