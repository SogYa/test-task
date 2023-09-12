package ru.sogya.work.testtask.data.model

import com.google.gson.annotations.SerializedName

data class StateListData(
    @SerializedName("data")
    val stateList: List<StateData>
)