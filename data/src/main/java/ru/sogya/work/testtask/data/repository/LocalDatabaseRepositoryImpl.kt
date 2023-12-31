package ru.sogya.work.testtask.data.repository

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.sogya.work.testtask.data.database.LocalDatabase
import ru.sogya.work.testtask.data.mapper.ClientInfoDomainMapper
import ru.sogya.work.testtask.domain.models.ClientInfoDomain
import ru.sogya.work.testtask.domain.repository.LocalDatabaseRepository

class LocalDatabaseRepositoryImpl(context: Context) : LocalDatabaseRepository {
    private val db = Room.databaseBuilder(
        context, LocalDatabase::class.java, "local-data-base"
    ).build()

    override fun getClientInfo(): Flow<ClientInfoDomain> = db.clientInfoDao().getClientInfo().map { it }

    override fun insertClientInfo(clientInfoDomain: ClientInfoDomain) =
        db.clientInfoDao().insertClientInfo(ClientInfoDomainMapper(clientInfoDomain).toData())
}