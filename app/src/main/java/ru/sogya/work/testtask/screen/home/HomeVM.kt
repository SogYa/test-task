package ru.sogya.work.testtask.screen.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ru.sogya.work.testtask.domain.usecase.GetClientInfoUseCase
import ru.sogya.work.testtask.mapper.ClientInfoDomainMapper
import ru.sogya.work.testtask.model.ClientInfoPresentation
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    getClientInfoUseCase: GetClientInfoUseCase
) : ViewModel() {
    private val clientInfoLiveData = MutableLiveData<ClientInfoPresentation>()

    init {
        viewModelScope.launch {
            getClientInfoUseCase().flowOn(Dispatchers.IO).catch {
                Log.e("GetClientError", it.message.toString())
            }.map {
                ClientInfoDomainMapper(it).toPresentation()
            }.collect {
                clientInfoLiveData.postValue(it)
            }
        }
    }

    fun getClientLiveData(): LiveData<ClientInfoPresentation> = clientInfoLiveData
}