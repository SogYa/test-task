package ru.sogya.work.testtask.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.sogya.work.testtask.data.repository.LocalDatabaseRepositoryImpl
import ru.sogya.work.testtask.domain.repository.LocalDatabaseRepository

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun provideLocalDatabaseRepository(@ApplicationContext context: Context): LocalDatabaseRepository =
        LocalDatabaseRepositoryImpl(context = context)
}