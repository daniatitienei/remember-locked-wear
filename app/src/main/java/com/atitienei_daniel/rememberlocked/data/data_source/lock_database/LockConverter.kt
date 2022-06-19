package com.atitienei_daniel.rememberlocked.data.data_source.lock_database

import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toLowerCase
import androidx.room.TypeConverter
import com.atitienei_daniel.rememberlocked.domain.model.LockStatus

class LockConverter {
    @TypeConverter
    fun fromString(value: String?): LockStatus = when (value?.toLowerCase(Locale.current)) {
        "locked" -> LockStatus.LOCKED
        else -> LockStatus.UNLOCKED
    }

    @TypeConverter
    fun toString(status: LockStatus): String = when (status) {
        LockStatus.LOCKED -> "locked"
        else -> "unlocked"
    }
}