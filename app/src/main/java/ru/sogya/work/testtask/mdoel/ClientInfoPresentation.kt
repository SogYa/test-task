package ru.sogya.work.testtask.mdoel

import ru.sogya.work.testtask.domain.models.ClientInfoDomain

data class ClientInfoPresentation(
    override val id: String,
    override val code: String,
    override val name: String,
    override val surname: String
) : ClientInfoDomain
