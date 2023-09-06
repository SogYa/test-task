package ru.sogya.work.testtask.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.sogya.work.testtask.domain.models.ClientInfoDomain
import ru.sogya.work.testtask.domain.repository.LocalDatabaseRepository


class GetClientInfoUseCase(
    private val localDatabaseRepository: LocalDatabaseRepository
) {
    operator fun invoke(): Flow<ClientInfoDomain> = localDatabaseRepository.getClientInfo()
}