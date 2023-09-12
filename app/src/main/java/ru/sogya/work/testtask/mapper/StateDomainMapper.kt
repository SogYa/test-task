package ru.sogya.work.testtask.mapper

import ru.sogya.work.testtask.domain.models.StateDomain
import ru.sogya.work.testtask.model.StatePresentation

class StateDomainMapper(private val stateDomain: StateDomain) {
    fun toPresentation() = StatePresentation(stateDomain.date, stateDomain.names)
}