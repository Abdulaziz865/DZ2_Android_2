package com.example.dz2_android_2

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.dz2_android_2.ui.data.db.AppDataBase
import com.example.dz2_android_2.util.SharedPreferenceUtil

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
        getInstance()
        SharedPreferenceUtil.units(this)
    }

    companion object {
        private var appDataBase: AppDataBase? = null
        private var context: Context? = null

        fun getInstance(): AppDataBase? {
            if (appDataBase == null) {
                appDataBase = context?.let {
                    Room.databaseBuilder(it, AppDataBase::class.java, "note.database")
                        .fallbackToDestructiveMigration().allowMainThreadQueries().build()
                }
            }
            return appDataBase
        }
    }
}