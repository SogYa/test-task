package ru.sogya.work.testtask.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sogya.work.testtask.domain.models.StateDomain

interface StatesRepository {
    fun getAllStates(): Flow<Map<String, List<StateDomain>>>
}