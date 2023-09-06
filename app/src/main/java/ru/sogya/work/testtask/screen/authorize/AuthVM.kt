package ru.sogya.work.testtask.screen.authorize

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.sogya.work.testtask.domain.usecase.InsertClientInfoUseCase
import ru.sogya.work.testtask.mapper.ClientInfoPresentationMapper
import ru.sogya.work.testtask.mdoel.ClientInfoPresentation
import javax.inject.Inject

@HiltViewModel
class AuthVM @Inject constructor(
    private val insertClientInfoUseCase: InsertClientInfoUseCase
) : ViewModel() {

    fun insertClientInfoToDatabase(id: Int, code: Int, name: String, surname: String) {
        viewModelScope.launch {
            val clientInfoPresentation = ClientInfoPresentation(id, code, name, surname)
            val clientInfoData = ClientInfoPresentationMapper(clientInfoPresentation).toData()
            insertClientInfoUseCase(clientInfoData)
        }
    }
}