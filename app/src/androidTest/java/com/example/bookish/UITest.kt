package com.example.bookish

import android.content.Context
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.espresso.Espresso
import androidx.test.platform.app.InstrumentationRegistry
import com.example.bookish.composables.MainScreen
import com.example.bookish.ui.theme.BookishTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UITest {

    private val appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    @get:Rule
    val composeTestRule = createComposeRule()


    private val libraryButton = hasText(appContext.getString(R.string.library)) and hasClickAction()
    private val listsButton = hasText(appContext.getString(R.string.lists)) and hasClickAction()
    private val settingsButton = hasText(appContext.getString(R.string.settings)) and hasClickAction()
    private val libraryTag = appContext.getString(R.string.library_tag)
    private val listsTag = appContext.getString(R.string.lists_tag)
    private val settingsTag = appContext.getString(R.string.settings_tag)
    private val scrollTag = appContext.getString(R.string.scroll_tag)


    @Before
    fun setUp() {
        composeTestRule.setContent {
            BookishTheme {
                MainScreen()
            }
        }
    }

    @Test
    fun verify_if_all_views_exists_in_the_nav_bar() {
        composeTestRule.onNode(libraryButton).assertIsDisplayed()
        composeTestRule.onNode(listsButton).assertIsDisplayed()
        composeTestRule.onNode(settingsButton).assertIsDisplayed()
    }

    @Test
    fun verify_if_all_views_clickable() {
        composeTestRule.onNode(listsButton).performClick()
        composeTestRule.onNode(settingsButton).performClick()
        composeTestRule.onNode(libraryButton).performClick()

    }

    @Test
    fun verify_if_back_stack_works_correctly() {
        composeTestRule.onNode(settingsButton).performClick()
        composeTestRule.onNode(listsButton).performClick()
        composeTestRule.onNode(settingsButton).performClick()
        Espresso.pressBack()
        composeTestRule.onNodeWithTag(listsTag).assertIsDisplayed()
    }

    @Test
    fun verify_if_back_stack_single_top_works_correctly() {
        composeTestRule.onNode(listsButton).performClick()
        composeTestRule.onNodeWithTag(listsTag).assertIsDisplayed()
        composeTestRule.onNode(listsButton).performClick()
        composeTestRule.onNodeWithTag(listsTag).assertIsDisplayed()
        composeTestRule.onNode(listsButton).performClick()
        composeTestRule.onNodeWithTag(listsTag).assertIsDisplayed()

        Espresso.pressBack()

        composeTestRule.onNodeWithTag(libraryTag).assertIsDisplayed()
    }

    @Test
    fun verify_navigation_to_library_screen() {
        composeTestRule.onNode(settingsButton).performClick()
        composeTestRule.onNode(libraryButton).performClick()
        composeTestRule.onNodeWithTag(libraryTag).assertIsDisplayed()
    }

    @Test
    fun verify_navigation_to_lists_screen() {
        composeTestRule.onNode(listsButton).performClick()
        composeTestRule.onNodeWithTag(listsTag).assertIsDisplayed()
    }

    @Test
    fun verify_navigation_to_settings_screen() {
        composeTestRule.onNode(settingsButton).performClick()
        composeTestRule.onNodeWithTag(settingsTag).assertIsDisplayed()
    }

    @Test
    fun verify_settings_pressable() {
        composeTestRule.onNode(settingsButton).performClick()
        composeTestRule.onNodeWithTag(settingsTag).assertIsDisplayed()
    }

//    @Test
//    fun verify_list_of_books_scrollable() {
//        composeTestRule.onNodeWithTag(scrollTag).assert(hasScrollAction())
//    }

    @Test
    fun verify_button_settings_screen_is_clickable() {
        composeTestRule.onNode(settingsButton).performClick()
        composeTestRule.onNodeWithText(appContext.getString(R.string.save)).performClick()
    }
}