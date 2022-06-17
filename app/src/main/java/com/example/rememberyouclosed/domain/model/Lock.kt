package com.example.rememberyouclosed.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.rememberyouclosed.data.data_source.LockConverter

@Entity
data class Lock(
    @PrimaryKey val id: Long? = null,
    val title: String?,
    val status: LockStatus?,
    val icon: Int? = null
)
