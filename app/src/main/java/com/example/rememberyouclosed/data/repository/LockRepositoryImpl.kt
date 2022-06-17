package com.example.rememberyouclosed.data.repository

import com.example.rememberyouclosed.data.data_source.LockDao
import com.example.rememberyouclosed.domain.model.Lock
import com.example.rememberyouclosed.domain.repository.LockRepository
import kotlinx.coroutines.flow.Flow

class LockRepositoryImpl(
    private val dao: LockDao
) : LockRepository {
    override fun getAllLocks(): Flow<List<Lock>> = dao.getAllLocks()

    override suspend fun insertLock(lock: Lock) {
        dao.insertLock(lock)
    }
}