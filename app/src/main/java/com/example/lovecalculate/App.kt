package com.example.lovecalculate

import android.app.Application
import androidx.room.Room
import com.example.lovecalculate.model.room.AppDatabase

class App: Application() {

    companion object{
        lateinit var appDatabase: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java,"love_file")
            .allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

}