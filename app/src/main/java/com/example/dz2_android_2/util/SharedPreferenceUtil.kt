package com.example.dz2_android_2.util

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceUtil {

    private lateinit var preferences: SharedPreferences

    fun units(context: Context) {
        preferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }

    var isPreference: Boolean
        get() = preferences.getBoolean("preference", true)
        set(value) = preferences.edit().putBoolean("preference", value).apply()
}