package com.atitienei_daniel.rememberlocked.presentation.screens.add_new_lock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atitienei_daniel.rememberlocked.domain.repository.LockRepository
import com.atitienei_daniel.rememberlocked.presentation.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddNewLockViewModel @Inject constructor(
    private val repository: LockRepository
) : ViewModel() {

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun onEvent(event: AddNewLockScreenEvents) {
        when (event) {
            is AddNewLockScreenEvents.OnCategoryClick -> {
                viewModelScope.launch {
                    repository.insertLock(event.category)
                    _uiEvent.emit(UiEvent.PopBackStack)
                }
            }
        }
    }
}