package com.example.fragmentchangetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private val firstFragment = DetailsFragment(1)
    private val secondFragment = DetailsFragment(2)
    private fun addFragment(f: DetailsFragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, f)
        transaction.commit()
    }

    private fun replaceFragment(f: DetailsFragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, f)
        transaction.commit()
    }
    // ------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(firstFragment)
        addFragment(secondFragment)
        val first_fragment = findViewById<Button>(R.id.first_fragment)
        val second_fragment = findViewById<Button>(R.id.second_fragment)
        first_fragment.setOnClickListener {
            replaceFragment(firstFragment)
        }
        second_fragment.setOnClickListener {
            replaceFragment(secondFragment)
        }
    }
}