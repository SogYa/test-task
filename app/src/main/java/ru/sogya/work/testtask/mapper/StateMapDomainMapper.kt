package ru.sogya.work.testtask.mapper

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import ru.sogya.work.testtask.domain.models.StateDomain
import ru.sogya.work.testtask.model.StateItem

class StateMapDomainMapper(
    private val stateMapDomain: Map<String, List<StateDomain>>
) {
    suspend fun toPresentationMap(): List<StateItem> {
        val presentationList = arrayListOf<StateItem>()
        coroutineScope {
            withContext(Dispatchers.Default) {
                stateMapDomain.keys.forEach { s ->
                    val headerItem = StateItem.HeaderItem(s)
                    presentationList.add(headerItem)
                    stateMapDomain[s]?.forEach { stateDomain ->
                        stateDomain.names.forEach {
                            val nameItem = StateItem.NameItem(it, s)
                            presentationList.add(nameItem)
                        }
                    }
                }
            }
        }
        return presentationList
    }
}