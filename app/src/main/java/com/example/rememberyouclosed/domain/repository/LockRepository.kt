package com.example.rememberyouclosed.domain.repository

import com.example.rememberyouclosed.domain.model.Lock
import kotlinx.coroutines.flow.Flow

interface LockRepository {
    fun getAllLocks(): Flow<List<Lock>>

    suspend fun insertLock(lock: Lock)
}