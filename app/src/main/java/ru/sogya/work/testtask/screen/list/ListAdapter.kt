package ru.sogya.work.testtask.screen.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.sogya.work.testtask.R
import ru.sogya.work.testtask.model.StateItem

class ListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var stateList = arrayListOf<StateItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.header_item -> HeaderViewHolder(view)
            R.layout.state_item -> NameViewHolder(view)
            else -> NameViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var item = stateList[position]
        when (holder) {
            is HeaderViewHolder -> {
                item = item as StateItem.HeaderItem
                holder.textView.text = item.headerDate
            }

            is NameViewHolder -> {
                item = item as StateItem.NameItem
                holder.textView.text = item.names
            }
        }
    }

    override fun getItemCount(): Int = stateList.size
    override fun getItemViewType(position: Int): Int =
        when (stateList[position]) {
            is StateItem.HeaderItem -> R.layout.header_item
            is StateItem.NameItem -> R.layout.state_item
        }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.headerTextView)
    }

    class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textViewName)
    }

    fun updateList(newList: List<StateItem>) {
        stateList.clear()
        notifyItemChanged(1)
        stateList.addAll(newList)
        notifyItemRangeChanged(0, stateList.size)
    }
}
