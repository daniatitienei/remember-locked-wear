package com.atitienei_daniel.rememberlocked.presentation.screens.update_lock_status

sealed class UpdateLockStatusScreenEvents {
    data class ToggleStepperValue(val value: Int) : UpdateLockStatusScreenEvents()
}