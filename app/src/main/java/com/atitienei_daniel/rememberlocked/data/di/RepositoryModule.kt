package com.atitienei_daniel.rememberlocked.data.di

import com.atitienei_daniel.rememberlocked.data.repository.LockRepositoryImpl
import com.atitienei_daniel.rememberlocked.domain.repository.LockRepository
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
    fun provideLockRepository(db: com.atitienei_daniel.rememberlocked.data.data_source.lock_database.LockDatabase): LockRepository =
        LockRepositoryImpl(db.dao)
}