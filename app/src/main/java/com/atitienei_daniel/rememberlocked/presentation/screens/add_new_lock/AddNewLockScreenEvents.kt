package com.atitienei_daniel.rememberlocked.presentation.screens.add_new_lock

import com.atitienei_daniel.rememberlocked.domain.model.LockCategory

sealed class AddNewLockScreenEvents {
    data class OnCategoryClick(val category: LockCategory) : AddNewLockScreenEvents()
}
