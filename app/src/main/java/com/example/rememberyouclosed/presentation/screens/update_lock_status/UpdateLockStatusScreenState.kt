package com.example.rememberyouclosed.presentation.screens.update_lock_status

import com.example.rememberyouclosed.domain.model.Lock

data class UpdateLockStatusScreenState(
    val lock: Lock? = null,
    val stepperValue: Int = 0
)