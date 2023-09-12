package ru.sogya.work.testtask.data.network.api

import retrofit2.http.GET
import ru.sogya.work.testtask.data.model.StateData

interface NetworkApi {

    @GET("/data")
    suspend fun getAllStates(): List<StateData>
}