package com.pro.androidexam

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2: Fragment(R.layout.fragment2) {
    private lateinit var listener: OnClickButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnClickButton
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<AppCompatTextView>(R.id.fr2Name)
        val number = view.findViewById<AppCompatTextView>(R.id.fr2Phone)
        name.text = arguments?.getString("name")
        number.text = arguments?.getString("number")
    }
}