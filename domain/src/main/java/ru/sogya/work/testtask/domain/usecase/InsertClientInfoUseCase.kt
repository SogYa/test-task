package ru.sogya.work.testtask.domain.usecase

import ru.sogya.work.testtask.domain.models.ClientInfoDomain
import ru.sogya.work.testtask.domain.repository.LocalDatabaseRepository

class InsertClientInfoUseCase(
    private val localDatabaseRepository: LocalDatabaseRepository
) {
    operator fun invoke(clientInfoDomain: ClientInfoDomain) =
        localDatabaseRepository.insertClientInfo(clientInfoDomain)
}