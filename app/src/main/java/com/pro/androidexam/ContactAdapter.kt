package com.pro.androidexam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView


class ContactAdapter(private val click: (contact: ContactItem) -> Unit)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private val contactList = mutableListOf<ContactItem>()

    fun setData(item: ContactItem) {
        contactList.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycle, parent, false)
        return ViewHolder(itemView, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = contactList[position]
        holder.bind(item)
    }

    override fun getItemCount() = contactList.size

    class ViewHolder( itemView: View, private val click: (contact: ContactItem) -> Unit) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: ContactItem) {
            val name = itemView.findViewById<AppCompatTextView>(R.id.itemName)
            val btnAdd = itemView.findViewById<AppCompatButton>(R.id.itemBtn)
            name.text = item.name
            btnAdd.setOnClickListener {
                click.invoke(item)
            }
        }
    }
}
