package ru.sogya.work.testtask.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import ru.sogya.work.testtask.domain.repository.StatesRepository
import ru.sogya.work.testtask.domain.usecase.states.GetAllStatesUseCase

@Module
@InstallIn(ViewModelComponent::class)
class StateModule {
    @Provides
    fun provideGetAllUseCase(statesRepository: StatesRepository): GetAllStatesUseCase =
        GetAllStatesUseCase(repository = statesRepository)
}