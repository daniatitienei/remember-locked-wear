package com.example.rememberyouclosed.data.repository

import com.example.rememberyouclosed.data.data_source.lock_database.LockDao
import com.example.rememberyouclosed.domain.model.Lock
import com.example.rememberyouclosed.domain.model.LockCategory
import com.example.rememberyouclosed.domain.model.LockStatus
import com.example.rememberyouclosed.domain.repository.LockRepository
import kotlinx.coroutines.flow.Flow

class LockRepositoryImpl(
    private val dao: LockDao
) : LockRepository {
    override fun getAllLocks(): Flow<List<Lock>> = dao.getAllLocks()

    override suspend fun insertLock(lockCategory: LockCategory) {
        val lock = Lock(
            title = lockCategory.title,
            icon = lockCategory.icon,
            status = LockStatus.UNLOCKED
        )
        dao.insertLock(lock)
    }
}