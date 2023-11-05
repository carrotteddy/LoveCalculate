package com.example.lovecalculate

import android.content.Context
import android.content.Context.MODE_PRIVATE
import javax.inject.Inject

class Prefs @Inject constructor(private val context: Context) {

    private val pref = context.getSharedPreferences(PREF_KEY, MODE_PRIVATE)

    fun isBordShown(): Boolean {
        return pref.getBoolean(BOARD_KEY, false)
    }

    fun onBoardShowed() {
        pref.edit().putBoolean(BOARD_KEY, true).apply()
    }

    companion object {
        const val PREF_KEY = "pref.key"
        const val BOARD_KEY = "board.key"
    }

}