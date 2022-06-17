package com.example.rememberyouclosed.domain.mappers

import com.example.rememberyouclosed.domain.model.LockStatus

fun LockStatus.convertToString(): String = when (this) {
    LockStatus.LOCKED -> "Locked"
    LockStatus.UNLOCKED -> "Unlocked"
}