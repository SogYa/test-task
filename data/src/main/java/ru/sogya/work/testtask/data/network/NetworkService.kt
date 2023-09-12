package ru.sogya.work.testtask.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.sogya.work.testtask.data.network.api.NetworkApi

object NetworkService {

    private const val BASE_URL = "https://mp21a3712c9cc3d8f07a.free.beeceptor.com"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: NetworkApi = getRetrofit().create(NetworkApi::class.java)
}