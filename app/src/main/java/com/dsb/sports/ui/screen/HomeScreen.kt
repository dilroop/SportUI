package com.dsb.sports.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dsb.sports.models.Sport
import com.dsb.sports.ui.SportSelectionStrategy
import com.dsb.sports.ui.SportsView

@Composable
fun HomeScreen(strategy: SportSelectionStrategy) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SportsView(
            nameFontSize = MaterialTheme.typography.body1.fontSize,
            descriptionFontSize = MaterialTheme.typography.body2.fontSize,
            sports = Sport.createMockedSports(),
            strategy = strategy
        )
        OutlinedButton(onClick = { strategy.refreshRandom() }) {
            Text(text = "Refresh")
        }
    }

}

@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
    HomeScreen(strategy = SportSelectionStrategy())
}

@Composable
@Preview(showBackground = true)
fun PreviewSportsView() {
    SportsView(
        nameFontSize = MaterialTheme.typography.body1.fontSize,
        descriptionFontSize = MaterialTheme.typography.body2.fontSize,
        spaceAfterName = 16.dp,
        modifier = Modifier.padding(16.dp),
        sports = Sport.Companion.createMockedSports()
    )
}

