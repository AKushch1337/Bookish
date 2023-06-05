package com.example.bookish

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.espresso.Espresso
import com.example.bookish.composables.MainScreen
import com.example.bookish.ui.theme.BookishTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    val LibraryButton = hasText("Library") and hasClickAction()
    val ListsButton = hasText("Lists") and hasClickAction()
    val SettingsButton = hasText("Settings") and hasClickAction()

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
        composeTestRule.onNode(LibraryButton).assertIsDisplayed()
        composeTestRule.onNode(ListsButton).assertIsDisplayed()
        composeTestRule.onNode(SettingsButton).assertIsDisplayed()
    }

    @Test
    fun verify_if_all_views_clickable() {
        composeTestRule.onNode(ListsButton).performClick()
        composeTestRule.onNode(SettingsButton).performClick()
        composeTestRule.onNode(LibraryButton).performClick()

    }

    @Test
    fun verify_if_back_stack_works_correctly() {
        composeTestRule.onNode(SettingsButton).performClick()
        composeTestRule.onNode(ListsButton).performClick()
        composeTestRule.onNode(SettingsButton).performClick()
        Espresso.pressBack()
        composeTestRule.onNodeWithTag("lists_tag").assertIsDisplayed()
    }

    @Test
    fun verify_if_back_stack_single_top_works_correctly() {
        composeTestRule.onNode(ListsButton).performClick()
        composeTestRule.onNodeWithTag("lists_tag").assertIsDisplayed()
        composeTestRule.onNode(ListsButton).performClick()
        composeTestRule.onNodeWithTag("lists_tag").assertIsDisplayed()
        composeTestRule.onNode(ListsButton).performClick()
        composeTestRule.onNodeWithTag("lists_tag").assertIsDisplayed()

        Espresso.pressBack()

        composeTestRule.onNodeWithTag("library_tag").assertIsDisplayed()
    }

    @Test
    fun verify_navigation_to_library_screen() {
        composeTestRule.onNode(SettingsButton).performClick()
        composeTestRule.onNode(LibraryButton).performClick()
        composeTestRule.onNodeWithTag("library_tag").assertIsDisplayed()
    }

    @Test
    fun verify_navigation_to_lists_screen() {
        composeTestRule.onNode(ListsButton).performClick()
        composeTestRule.onNodeWithTag("lists_tag").assertIsDisplayed()
    }

    @Test
    fun verify_navigation_to_settings_screen() {
        composeTestRule.onNode(SettingsButton).performClick()
        composeTestRule.onNodeWithTag("settings_tag").assertIsDisplayed()
    }
}