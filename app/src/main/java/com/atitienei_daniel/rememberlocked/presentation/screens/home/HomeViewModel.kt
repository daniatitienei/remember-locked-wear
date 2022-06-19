package com.atitienei_daniel.rememberlocked.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atitienei_daniel.rememberlocked.domain.repository.LockRepository
import com.atitienei_daniel.rememberlocked.presentation.util.Routes
import com.atitienei_daniel.rememberlocked.presentation.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: LockRepository
) : ViewModel() {

    var locks = repository.getAllLocks()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun onEvent(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.OnAddNewLockClick -> {
                emitEvent(UiEvent.Navigate(route = Routes.AddNewLockScreen))
            }
            is HomeScreenEvents.OnLockClick -> {
                emitEvent(
                    UiEvent.Navigate(
                        route = Routes.UpdateLockStatusScreen.replace(
                            "{lockId}",
                            event.id.toString()
                        )
                    )
                )
            }
        }
    }

    private fun emitEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.emit(event)
        }
    }
}