package com.pro.androidexam

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1: Fragment(R.layout.fragment1)  {
    private lateinit var listener: OnClickButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickButton
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.frRecycleView)
        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = ContactAdapter {
            Toast.makeText(activity, "ITEM -$it", Toast.LENGTH_SHORT).show()
            listener.onClicked(it.name, it.phone)
        }

        val btn = view.findViewById<AppCompatButton>(R.id.btnAddContact)
        val edName = view.findViewById<AppCompatEditText>(R.id.editName)
        val edNumber = view.findViewById<AppCompatEditText>(R.id.editPhone)

        btn.setOnClickListener {

            val name = edName.text.toString()
            val number = edNumber.text.toString()
            if (name != "" && number != "") {
                val contact = ContactItem(name, number)
                adapter.setData(contact)
            }
        }
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))
        }
}


