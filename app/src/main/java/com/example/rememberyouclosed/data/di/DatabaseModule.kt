package com.example.rememberyouclosed.data.di

import android.app.Application
import androidx.room.Room
import com.example.rememberyouclosed.data.data_source.lock_database.LockDatabase
import com.example.rememberyouclosed.data.repository.LockRepositoryImpl
import com.example.rememberyouclosed.domain.repository.LockRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLockDatabase(application: Application): LockDatabase = Room
        .databaseBuilder(
            application,
            LockDatabase::class.java,
            LockDatabase.DATABASE_NAME
        )
        .build()

    @Provides
    @Singleton
    fun provideLockRepository(db: LockDatabase): LockRepository = LockRepositoryImpl(db.lockDao)
}