package ru.sogya.work.testtask.data.model

import ru.sogya.work.testtask.domain.models.StateDomain

data class StateData(override val date: String, override val names: List<String>) : StateDomain
