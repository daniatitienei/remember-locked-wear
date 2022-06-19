package com.atitienei_daniel.rememberlocked.domain.mappers

import com.atitienei_daniel.rememberlocked.domain.model.LockStatus

fun LockStatus.asString(): String = when (this) {
    LockStatus.LOCKED -> "Locked"
    LockStatus.UNLOCKED -> "Unlocked"
}

fun lockStatusFromInt(ordinal: Int): LockStatus = when (ordinal) {
    LockStatus.LOCKED.ordinal -> LockStatus.LOCKED
    else -> LockStatus.UNLOCKED
}