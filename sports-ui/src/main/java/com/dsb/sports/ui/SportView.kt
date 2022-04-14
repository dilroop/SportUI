package com.dsb.sports.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.dsb.sports.models.Sport
import java.lang.IllegalStateException
import kotlin.random.Random
import kotlin.random.nextInt

@Composable
fun SportsView(
    modifier: Modifier = Modifier,
    nameFontSize: TextUnit,
    descriptionFontSize: TextUnit,
    spaceAfterName: Dp = 16.dp,
    sports: List<Sport>,
    strategy: SportSelectionStrategy = SportSelectionStrategy()
) {
    fun selectRandom(): Sport {
        val random = Random(System.currentTimeMillis())
        val index = random.nextInt(0 until sports.count())
        return sports[index]
    }

    var sport: Sport by remember { mutableStateOf(selectRandom()) }
    strategy.onSelectionUpdated {
        sport = selectRandom()
    }
    Column(modifier = modifier) {
        Text(text = sport.name, fontSize = nameFontSize)
        Spacer(modifier = Modifier.height(spaceAfterName))
        Text(text = sport.description, fontSize = descriptionFontSize)
    }
}

class SportSelectionStrategy {
    private lateinit var refreshListener: () -> Unit
    fun onSelectionUpdated(listener: () -> Unit) {
        this.refreshListener = listener
    }

    fun refreshRandom() {
        if (!::refreshListener.isInitialized) {
            throw IllegalStateException("Strategy should be registered with the SportsView.")
        }
        refreshListener()
    }
}
