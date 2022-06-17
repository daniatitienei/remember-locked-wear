package com.example.rememberyouclosed.domain.model

import androidx.room.Entity

@Entity
data class LockCategory(
    val title: String,
    val icon: Int
)
