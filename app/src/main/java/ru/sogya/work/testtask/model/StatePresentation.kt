package ru.sogya.work.testtask.model

import ru.sogya.work.testtask.domain.models.StateDomain

data class StatePresentation(override val date: String, override val names: List<String>) :
    StateDomain
