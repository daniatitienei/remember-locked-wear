package com.atitienei_daniel.rememberlocked.data.di

import android.app.Application
import androidx.room.Room
import com.atitienei_daniel.rememberlocked.data.data_source.lock_database.LockDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideLockDatabase(application: Application): com.atitienei_daniel.rememberlocked.data.data_source.lock_database.LockDatabase = Room
        .databaseBuilder(
            application,
            LockDatabase::class.java,
            LockDatabase.DATABASE_NAME
        )
        .build()
}