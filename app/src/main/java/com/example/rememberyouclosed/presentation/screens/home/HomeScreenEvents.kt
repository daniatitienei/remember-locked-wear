package com.example.rememberyouclosed.presentation.screens.home

sealed class HomeScreenEvents {
    object OnAddNewLockClick : HomeScreenEvents()
    data class OnLockClick(val id: Long) : HomeScreenEvents()
}
