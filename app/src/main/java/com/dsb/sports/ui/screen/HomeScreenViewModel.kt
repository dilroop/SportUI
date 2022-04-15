package com.dsb.sports.ui.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dsb.sports.data.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: ContentRepository
) : ViewModel() {
    private val _viewState = mutableStateOf<HomeScreenViewState>(HomeScreenViewState.Loading)
    val viewState: State<HomeScreenViewState> = _viewState

    init {
        getAllSports()
    }

    private fun getAllSports() {
        _viewState.value = HomeScreenViewState.Loading
        viewModelScope.launch {
            val sports = repository.getFeaturedSports()
            _viewState.value = HomeScreenViewState.Content(sports = sports)
        }
    }
}