package ru.sogya.work.testtask.data

import kotlinx.coroutines.flow.Flow
import ru.sogya.work.testtask.domain.models.ClientInfoDomain
import ru.sogya.work.testtask.domain.repository.LocalDatabaseRepository

class LocalDatabaseRepositoryImpl:LocalDatabaseRepository {
    override fun getClientInfo(): Flow<ClientInfoDomain> {
        TODO("Not yet implemented")
    }

    override fun insertClientInfo(clientInfoDomain: ClientInfoDomain) {
        TODO("Not yet implemented")
    }
}