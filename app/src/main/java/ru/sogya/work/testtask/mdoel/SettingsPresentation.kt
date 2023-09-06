package ru.sogya.work.testtask.mdoel

sealed class SettingsPresentation {
    data class DefaultSettingsItem(val text: String, val hint: String? = null) : SettingsPresentation()
    data class SwitchSettingsItem(val text: String) : SettingsPresentation()
    data class EmailSettingsItem(val text: String, val email: String, val verifyHint: String? = null) :
        SettingsPresentation()

    data class HeaderSettingsItem(val text: String) : SettingsPresentation()
}
