package ru.sogya.work.testtask.data.network.api

import retrofit2.http.GET
import ru.sogya.work.testtask.data.model.StateListData

interface NetworkApi {

    @GET("/data")
    suspend fun getAllStates(): StateListData
}