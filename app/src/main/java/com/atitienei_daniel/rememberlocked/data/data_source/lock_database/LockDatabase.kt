package com.atitienei_daniel.rememberlocked.data.data_source.lock_database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.atitienei_daniel.rememberlocked.domain.model.Lock

@Database(
    entities = [Lock::class], version = 1
)
@TypeConverters(LockConverter::class)
abstract class LockDatabase : RoomDatabase() {

    abstract val dao: LockDao

    companion object {
        const val DATABASE_NAME = "lock-database"
    }
}