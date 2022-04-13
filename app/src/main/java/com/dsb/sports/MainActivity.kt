package com.dsb.sports

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dsb.sports.models.Sport
import com.dsb.sports.ui.SportSelectionStrategy
import com.dsb.sports.ui.SportsView
import com.dsb.sports.ui.theme.SportsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportsTheme {
                val strategy = SportSelectionStrategy()
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Sporty") },
                            actions = {
                                Icon(
                                    modifier = Modifier
                                        .padding(end = 8.dp)
                                        .clickable {
                                            strategy.refreshRandom()
                                        },
                                    imageVector = Icons.Default.Refresh,
                                    contentDescription = null,
                                )
                            }
                        )
                    }
                ) {
                    Surface(modifier = Modifier.padding(it), color = MaterialTheme.colors.background) {
                        HomeScreen(strategy = strategy)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(strategy: SportSelectionStrategy) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SportsView(
            nameFontSize = MaterialTheme.typography.body1.fontSize,
            descriptionFontSize = MaterialTheme.typography.body2.fontSize,
            spaceAfterName = 16.dp,
            sports = Sport.Companion.createMockedSports(),
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
//@Preview(showBackground = true)
fun PreviewSportsView() {
    SportsView(
        nameFontSize = MaterialTheme.typography.body1.fontSize,
        descriptionFontSize = MaterialTheme.typography.body2.fontSize,
        spaceAfterName = 16.dp,
        modifier = Modifier.padding(16.dp),
        sports = Sport.Companion.createMockedSports()
    )
}

