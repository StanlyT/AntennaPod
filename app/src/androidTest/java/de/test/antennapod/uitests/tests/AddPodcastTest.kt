package de.test.antennapod.uitests.tests

import de.test.antennapod.uitests.screens.PodcastContainerScreen
import de.test.antennapod.uitests.screens.SearchResultScreen
import de.test.antennapod.uitests.screens.toolbar_screens.AddPodcastScreen
import de.test.antennapod.uitests.screens.toolbar_screens.AddPodcastScreen.isScreenDisplayed
import de.test.antennapod.uitests.screens.toolbar_screens.AddPodcastScreen.searchButton
import de.test.antennapod.uitests.screens.toolbar_screens.AddPodcastScreen.searchEditText
import org.junit.Before
import org.junit.Test

class AddPodcastTest : BaseTest() {

    @Before
    fun setUpBase() {
        startApp()
    }

    @Test
    fun should_be_able_to_find_podcast_by_title() {
        val searchingPodcast = "SQA Interviews"
        testCaseRule.run {
            step("Check is Add Podcast Screen and its main UI elements are displayed") {
                AddPodcastScreen {
                    flakySafely { isScreenDisplayed() }
                    searchButton.isDisplayed()
                    searchEditText.isDisplayed()
                }
            }
            step("Enter searching podcast's name $searchingPodcast and click find it") {
                AddPodcastScreen {
                    searchEditText.typeText(searchingPodcast)
                    searchButton.click()
                }
            }
            step("Check is search result screen displayed") {
                SearchResultScreen {
                    flakySafely { isScreenDisplayed() }
                }
            }
            step("Check whether first found result contains $searchingPodcast and then click it") {
                SearchResultScreen {
                    searchResultList {
                        hasSize(1)
                        firstChild<SearchResultScreen.ResultItem> {
                            txtTitle.hasText(searchingPodcast)
                            txtAuthor.hasAnyText()
                            click()
                        }
                    }
                }
            }
            step("Check whether podcast container with name $searchingPodcast is displayed") {
                PodcastContainerScreen {
                    flakySafely { isScreenDisplayed() }
                    titleLabel.hasText(searchingPodcast)
                }
            }
        }
    }
}