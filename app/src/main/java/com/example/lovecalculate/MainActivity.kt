package com.example.lovecalculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = CalculateFragment()
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.container, fragment).commit()
    }
}