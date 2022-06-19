package com.atitienei_daniel.rememberlocked.domain.repository

import com.atitienei_daniel.rememberlocked.domain.model.Lock
import com.atitienei_daniel.rememberlocked.domain.model.LockCategory
import kotlinx.coroutines.flow.Flow

interface LockRepository {
    fun getAllLocks(): Flow<List<Lock>>

    suspend fun getLockById(id: Long): Lock

    suspend fun insertLock(lockCategory: LockCategory)

    suspend fun updateLock(lock: Lock)
}