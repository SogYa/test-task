package ru.sogya.work.testtask.model

sealed class StateItem {
    data class HeaderItem(val headerDate: String) : StateItem()
    data class NameItem(val names: String,val date:String) : StateItem()
}
