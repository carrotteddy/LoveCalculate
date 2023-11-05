package com.example.lovecalculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lovecalculate.onBoarding.OnBoardFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var prefs: Prefs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!prefs.isBordShown()) {
            val fragment = OnBoardFragment()
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().add(R.id.container, fragment).commit()
        } else {
            val fragment = CalculateFragment()
            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction().add(R.id.container, fragment).commit()
        }
    }
}