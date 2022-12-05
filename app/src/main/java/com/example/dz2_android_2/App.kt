package com.example.dz2_android_2

import android.app.Application
import com.example.dz2_android_2.fragments.util.SharedPreferenceUtil

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreferenceUtil.units(this)
    }
}