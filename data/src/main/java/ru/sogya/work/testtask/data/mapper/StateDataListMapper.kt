package ru.sogya.work.testtask.data.mapper

import ru.sogya.work.testtask.data.model.StateData
import ru.sogya.work.testtask.domain.models.StateDomain
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class StateDataListMapper(
    private val listStateData: List<StateData>
) {
    fun toDomainList(): List<StateDomain> {
        val list = arrayListOf<StateDomain>()
        listStateData.forEach {
            val datePattern = DateTimeFormatter.ofPattern("dd MMMM yyyy")
            it.date = ZonedDateTime.parse(it.date).format(datePattern)
            list.add(it)
        }
        return list
    }
}