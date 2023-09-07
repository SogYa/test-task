package ru.sogya.work.testtask.screen.authorize

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.sogya.work.testtask.domain.usecase.InsertClientInfoUseCase
import ru.sogya.work.testtask.mapper.ClientInfoPresentationMapper
import ru.sogya.work.testtask.model.ClientInfoPresentation
import javax.inject.Inject

@HiltViewModel
class AuthVM @Inject constructor(
    private val insertClientInfoUseCase: InsertClientInfoUseCase
) : ViewModel() {
    private val validationLiveData = MutableLiveData<Boolean>()
    private val validList = hashSetOf<Int>()

    fun insertClientInfoToDatabase(id: String, code: String, name: String, surname: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val clientInfoPresentation = ClientInfoPresentation(id, code, name, surname)
            val clientInfoData = ClientInfoPresentationMapper(clientInfoPresentation).toData()
            insertClientInfoUseCase(clientInfoData)
        }
    }

    fun validField(id: Int, text: String?, length: Int? = null, callback: ((valid: Boolean) -> Unit)? = null) {
        if (text.isNullOrEmpty()) {
            validList.remove(id)
        } else {
            if (length != null && text.length == length) {
                validList.add(id)
                callback?.invoke(true)
            } else if (length != null && text.length < length) {
                validList.remove(id)
                callback?.invoke(false)
            } else if (length == null) {
                validList.add(id)
            }
        }
        validateFields()
    }

    private fun validateFields() {
        validationLiveData.value = validList.size == 4
    }

    fun getValidationLiveData(): LiveData<Boolean> = validationLiveData
}