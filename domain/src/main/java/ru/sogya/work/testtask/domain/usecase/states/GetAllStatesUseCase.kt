package ru.sogya.work.testtask.domain.usecase.states

import ru.sogya.work.testtask.domain.repository.StatesRepository

class GetAllStatesUseCase(private val repository: StatesRepository) {
    operator fun invoke() = repository.getAllStates()
}