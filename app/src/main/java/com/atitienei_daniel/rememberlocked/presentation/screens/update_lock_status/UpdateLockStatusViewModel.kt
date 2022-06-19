package com.atitienei_daniel.rememberlocked.presentation.screens.update_lock_status

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atitienei_daniel.rememberlocked.domain.mappers.lockStatusFromInt
import com.atitienei_daniel.rememberlocked.domain.repository.LockRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateLockStatusViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: LockRepository
) : ViewModel() {

    private val _state = MutableStateFlow(UpdateLockStatusScreenState())
    val state = _state.asStateFlow()

    init {
        val lockId = savedStateHandle.get<String>("lockId")?.toLong()

        lockId?.let { id ->
            viewModelScope.launch {
                val lock = repository.getLockById(id)

                _state.value = _state.value.copy(
                    lock = lock,
                    stepperValue = lock.status!!.ordinal
                )
            }
        }
    }

    fun onEvent(event: UpdateLockStatusScreenEvents) {
        when (event) {
            is UpdateLockStatusScreenEvents.ToggleStepperValue -> {
                _state.value = _state.value.copy(
                    stepperValue = event.value
                )
                val newLock = _state.value.lock?.copy(status = lockStatusFromInt(event.value))

                newLock?.let {
                    viewModelScope.launch {
                        repository.updateLock(newLock)
                    }
                }
            }
        }
    }
}