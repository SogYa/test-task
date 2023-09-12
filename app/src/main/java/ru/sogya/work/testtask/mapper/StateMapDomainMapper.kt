package ru.sogya.work.testtask.mapper

import ru.sogya.work.testtask.domain.models.StateDomain
import ru.sogya.work.testtask.model.StatePresentation

class StateMapDomainMapper(
    private val stateMapdomain: Map<String, List<StateDomain>>
) {
    fun toPresentationMap(): Map<String, List<StatePresentation>> {
        return stateMapdomain.mapValues {
            StateListDomainMapper(it.value).toPresentationList()
        }
    }
}