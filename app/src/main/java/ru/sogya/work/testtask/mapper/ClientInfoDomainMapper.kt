package ru.sogya.work.testtask.mapper

import ru.sogya.work.testtask.domain.models.ClientInfoDomain
import ru.sogya.work.testtask.mdoel.ClientInfoPresentation

class ClientInfoDomainMapper(private val clientInfoDomain: ClientInfoDomain) {
    fun toPresentation() = ClientInfoPresentation(
        clientInfoDomain.id,
        clientInfoDomain.code,
        clientInfoDomain.name,
        clientInfoDomain.surname
    )
}