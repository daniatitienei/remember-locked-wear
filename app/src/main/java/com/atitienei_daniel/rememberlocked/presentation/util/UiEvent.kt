package com.atitienei_daniel.rememberlocked.presentation.util

sealed class UiEvent {
    data class Navigate(val route: String) : UiEvent()
    object PopBackStack : UiEvent()
}