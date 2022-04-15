package com.dsb.sports.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dsb.sports.models.Sport
import com.dsb.sports.ui.SportSelectionStrategy
import com.dsb.sports.ui.SportsView

@Composable
fun HomeScreen(strategy: SportSelectionStrategy, viewModel: HomeScreenViewModel = hiltViewModel()) {
    val viewState by viewModel.viewState
    when (viewState) {
        is HomeScreenViewState.Content -> {
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
        HomeScreenViewState.Loading -> {
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewHomeScreen() {
    HomeScreen(strategy = SportSelectionStrategy(), viewModel = hiltViewModel())
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

