package com.example.rememberyouclosed.data.di

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
object RepositoryModule {

    @Provides
    @Singleton
    fun provideLockRepository(db: LockDatabase): LockRepository =
        LockRepositoryImpl(db.dao)
}