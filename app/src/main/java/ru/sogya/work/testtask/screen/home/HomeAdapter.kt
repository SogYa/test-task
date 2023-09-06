package ru.sogya.work.testtask.screen.home

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sogya.work.testtask.R
import ru.sogya.work.testtask.mdoel.SettingsPresentation.*


class HomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val list = arrayListOf(
        HeaderSettingsItem("Мои покупки"),
        DefaultSettingsItem(""),
        HeaderSettingsItem("Настройки"),
        EmailSettingsItem("E-mail", "kursantik341@gmail.com", "Необходимо подтверждение"),
        SwitchSettingsItem("Вход по биометрии"),
        DefaultSettingsItem("Сменить 4-ч значный код"),
        DefaultSettingsItem("Регистрация для клиентов банка"),
        DefaultSettingsItem("Язык", "русский"),
    )

    override fun getItemViewType(position: Int): Int = when(list[position]){
        is HeaderSettingsItem -> R.layout.home_item_header
        is DefaultSettingsItem -> R.layout.home_item_default
        is SwitchSettingsItem -> R.layout.home_item_switch
        is EmailSettingsItem -> R.layout.home_item_default
    }
    class DefaultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}