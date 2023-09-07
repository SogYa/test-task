package ru.sogya.work.testtask.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.sogya.work.testtask.domain.models.ClientInfoDomain

@Entity(tableName = "client_info")
data class ClientInfoData(
    @PrimaryKey
    override val id: String,
    override val code: String,
    override val name: String,
    override val surname: String
) : ClientInfoDomain