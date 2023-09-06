package ru.sogya.work.testtask.data.mapper

import ru.sogya.work.testtask.data.model.ClientInfoData
import ru.sogya.work.testtask.domain.models.ClientInfoDomain

class ClientInfoDomainMapper(
    private val clientInfoDomain: ClientInfoDomain
) {
    fun toData() = ClientInfoData(
        clientInfoDomain.id,
        clientInfoDomain.code,
        clientInfoDomain.name,
        clientInfoDomain.surname
    )
}