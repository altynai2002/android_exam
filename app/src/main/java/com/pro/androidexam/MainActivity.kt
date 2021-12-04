package com.pro.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pro.androidexam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickButton{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Fragment1())
            .commit()
    }

    override fun onClicked(name: String, phone: String) {
        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("number", phone)
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment2)
            .addToBackStack(null) // чтобы возвр-ся к предыдущему
            .commit()

    }

}

