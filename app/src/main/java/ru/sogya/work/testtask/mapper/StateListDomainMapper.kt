package ru.sogya.work.testtask.mapper

import ru.sogya.work.testtask.domain.models.StateDomain
import ru.sogya.work.testtask.model.StatePresentation

class StateListDomainMapper(
    private val listStateDomain: List<StateDomain>
) {
    fun toPresentationList(): List<StatePresentation> {
        val list = arrayListOf<StatePresentation>()
        listStateDomain.forEach {
            list.add(StateDomainMapper(it).toPresentation())
        }
        return list
    }
}