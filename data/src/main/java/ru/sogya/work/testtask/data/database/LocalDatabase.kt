package ru.sogya.work.testtask.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.sogya.work.testtask.data.database.dao.ClientInfoDao
import ru.sogya.work.testtask.data.model.ClientInfoData

@Database(entities = [ClientInfoData::class], version = 1)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun clientInfoDao(): ClientInfoDao
}