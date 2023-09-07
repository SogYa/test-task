package ru.sogya.work.testtask.mapper

import ru.sogya.work.testtask.domain.models.ClientInfoDomain
import ru.sogya.work.testtask.model.ClientInfoPresentation

class ClientInfoDomainMapper(private val clientInfoDomain: ClientInfoDomain?) {
    fun toPresentation() = clientInfoDomain?.let {
        ClientInfoPresentation(
            it.id,
            it.code,
            it.name,
            it.surname
        )
    }
}