package ru.sogya.work.testtask.data.model

import com.google.gson.annotations.SerializedName
import ru.sogya.work.testtask.domain.models.StateDomain

data class StateData(
    @SerializedName("date")
    override val date: String,
    @SerializedName("name")
    override val names: List<String>) : StateDomain
