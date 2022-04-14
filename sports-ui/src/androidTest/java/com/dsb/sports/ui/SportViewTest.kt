package com.dsb.sports.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dsb.sports.models.Sport
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SportViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun sportsView_renders() {
        composeTestRule.setContent {
            SportsView(
                nameFontSize = MaterialTheme.typography.body1.fontSize,
                descriptionFontSize = MaterialTheme.typography.body2.fontSize,
                sports = listOf(Sport("ABC", "Body of the sport."))
            )
        }
        composeTestRule.onNodeWithText(text = "ABC").assertExists()
        composeTestRule.onNodeWithText(text = "Body of the sport.").assertExists()
    }
}