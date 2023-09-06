package ru.sogya.work.testtask.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.sogya.work.testtask.domain.models.ClientInfoDomain


interface LocalDatabaseRepository {
    fun getClientInfo(): Flow<ClientInfoDomain>

    fun insertClientInfo(clientInfoDomain: ClientInfoDomain)
}