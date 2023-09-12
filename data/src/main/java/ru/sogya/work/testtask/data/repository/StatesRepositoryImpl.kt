package ru.sogya.work.testtask.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.sogya.work.testtask.data.network.NetworkService
import ru.sogya.work.testtask.domain.models.StateDomain
import ru.sogya.work.testtask.domain.repository.StatesRepository

class StatesRepositoryImpl : StatesRepository {
    private val apiService = NetworkService.apiService
    override fun getAllStates(): Flow<List<StateDomain>> = flow {
        emit(apiService.getAllStates().stateList)
    }
}