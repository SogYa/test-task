package ru.sogya.work.testtask.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.sogya.work.testtask.data.model.ClientInfoData

@Dao
interface ClientInfoDao {
    @Query("SELECT * FROM client_info")
    fun getClientInfo(): Flow<ClientInfoData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClientInfo(clientInfoData: ClientInfoData)
}