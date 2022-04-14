package com.dsb.sports.ui

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dsb.sports.R
import com.dsb.sports.ui.screen.HomeScreen
import com.dsb.sports.ui.theme.SportsTheme

@Composable
fun SportyApp() {
    SportsTheme {
        val strategy = SportSelectionStrategy()
        Scaffold(
            topBar = { SportyAppBar(strategy = strategy) }
        ) {
            Surface(modifier = Modifier.padding(it), color = MaterialTheme.colors.background) {
                HomeScreen(strategy = strategy)
            }
        }
    }
}

@Composable
fun SportyAppBar(strategy: SportSelectionStrategy) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        actions = {
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable { strategy.refreshRandom() },
                imageVector = Icons.Default.Refresh,
                contentDescription = null,
            )
        }
    )
}

@Composable
//@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun PreviewSportyAppBar() {
    SportyAppBar(strategy = SportSelectionStrategy())
}
