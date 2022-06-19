package com.atitienei_daniel.rememberlocked.data.data_source.lock_database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.atitienei_daniel.rememberlocked.domain.model.Lock
import kotlinx.coroutines.flow.Flow

@Dao
interface LockDao {
    @Query("SELECT * FROM lock")
    fun getAllLocks(): Flow<List<Lock>>

    @Query("SELECT * FROM lock WHERE id = :id")
    suspend fun getLockById(id: Long): Lock

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLock(lock: Lock)

    @Update
    suspend fun updateLock(lock: Lock)
}