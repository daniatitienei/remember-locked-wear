package com.example.rememberyouclosed.data.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.rememberyouclosed.data.data_source.LockDao
import com.example.rememberyouclosed.data.data_source.LockDatabase
import com.example.rememberyouclosed.data.repository.LockRepositoryImpl
import com.example.rememberyouclosed.domain.repository.LockRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
        ).build()

    @Provides
    @Singleton
    fun provideLockRepository(db: LockDatabase): LockRepository = LockRepositoryImpl(db.lockDao)
}