package com.example.rememberyouclosed.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Lock(
    @PrimaryKey val id: Long? = null,
    val title: String? = null,
    val status: LockStatus? = null,
    val icon: Int? = null
)
