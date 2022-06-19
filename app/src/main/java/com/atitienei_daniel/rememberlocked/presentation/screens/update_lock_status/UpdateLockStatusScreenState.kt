package com.atitienei_daniel.rememberlocked.presentation.screens.update_lock_status

import com.atitienei_daniel.rememberlocked.domain.model.Lock

data class UpdateLockStatusScreenState(
    val lock: Lock? = null,
    val stepperValue: Int = 0
)