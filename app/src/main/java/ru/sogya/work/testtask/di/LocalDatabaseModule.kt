package ru.sogya.work.testtask.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.sogya.work.testtask.domain.repository.LocalDatabaseRepository
import ru.sogya.work.testtask.domain.usecase.GetClientInfoUseCase
import ru.sogya.work.testtask.domain.usecase.InsertClientInfoUseCase

@Module
@InstallIn(ViewModelComponent::class)
class LocalDatabaseModule {
    @Provides
    fun provideGetClientInfoUseCase(localDatabaseRepository: LocalDatabaseRepository) =
        GetClientInfoUseCase(localDatabaseRepository)

    @Provides
    fun provideInsertClientInfoUseCase(localDatabaseRepository: LocalDatabaseRepository) =
        InsertClientInfoUseCase(localDatabaseRepository)
}