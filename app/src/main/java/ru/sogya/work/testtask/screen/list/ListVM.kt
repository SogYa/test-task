package ru.sogya.work.testtask.screen.list

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
import ru.sogya.work.testtask.domain.usecase.states.GetAllStatesUseCase
import ru.sogya.work.testtask.mapper.StateListDomainMapper
import ru.sogya.work.testtask.model.StatePresentation
import javax.inject.Inject

@HiltViewModel
class ListVM @Inject constructor(getAllStatesUseCase: GetAllStatesUseCase) :
    ViewModel() {
    private val stateLiveData = MutableLiveData<List<StatePresentation>>()

    init {
        viewModelScope.launch {
            getAllStatesUseCase().flowOn(Dispatchers.IO).catch {
                Log.e("StateListError", it.message.toString())
            }.map {
                StateListDomainMapper(it).toPresentationList()
            }.collect {
                stateLiveData.postValue(it)
            }
        }
    }

    fun getStateLiveData(): LiveData<List<StatePresentation>> = stateLiveData
}