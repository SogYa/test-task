package ru.sogya.work.testtask.data.repository

import kotlinx.coroutines.flow.Flow
import ru.sogya.work.testtask.domain.models.StateDomain
import ru.sogya.work.testtask.domain.repository.StatesRepository

class StateRepositoryImpl:StatesRepository {
    override fun getAllStates(): Flow<List<StateDomain>> {
        TODO("Not yet implemented")
    }
}