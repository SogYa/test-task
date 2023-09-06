package ru.sogya.work.testtask.mapper

import ru.sogya.work.testtask.data.model.ClientInfoData
import ru.sogya.work.testtask.mdoel.ClientInfoPresentation

class ClientInfoPresentationMapper(private val clientInfoPresentation: ClientInfoPresentation) {
    fun toData() = ClientInfoData(
        clientInfoPresentation.id,
        clientInfoPresentation.code,
        clientInfoPresentation.name,
        clientInfoPresentation.surname
    )
}