package de.test.antennapod.uitests.tests

import android.content.Intent
import androidx.test.rule.ActivityTestRule
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcaserule.TestCaseRule
import de.danoeh.antennapod.activity.MainActivity
import org.junit.Rule

open class BaseTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @get:Rule
    val testCaseRule = TestCaseRule(javaClass.simpleName,
        kaspressoBuilder = Kaspresso.Builder.advanced().apply {
            flakySafetyParams.apply {
                timeoutMs = 5000
            }
        })

    fun startApp(screenIntent: Intent? = null): MainActivity = activityRule.launchActivity(screenIntent)
}