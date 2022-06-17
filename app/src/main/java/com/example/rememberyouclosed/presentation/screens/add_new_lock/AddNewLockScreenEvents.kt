package com.example.rememberyouclosed.presentation.screens.add_new_lock

import com.example.rememberyouclosed.domain.model.LockCategory

sealed class AddNewLockScreenEvents {
    data class OnCategoryClick(val category: LockCategory) : AddNewLockScreenEvents()
}
