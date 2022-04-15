package com.dsb.sports.ui.screen

import com.dsb.sports.models.Sport

sealed class HomeScreenViewState {

    object Loading : HomeScreenViewState()

    data class Content(
        val sports: List<Sport>
    ) : HomeScreenViewState()
}