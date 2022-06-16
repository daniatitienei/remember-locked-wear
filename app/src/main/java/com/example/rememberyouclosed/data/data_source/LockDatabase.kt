package com.example.rememberyouclosed.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rememberyouclosed.domain.model.Lock

@Database(
    entities = [Lock::class], version = 1
)
abstract class LockDatabase : RoomDatabase() {

    abstract val lockDao: LockDao

    companion object {
        const val DATABASE_NAME = "lock-database"
    }
}