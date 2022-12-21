package com.example.dz2_android_2.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.dz2_android_2.R
import com.example.dz2_android_2.util.SharedPreferenceUtil

class MainActivity : AppCompatActivity() {

    private lateinit var controllerNav: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controllerNav = navHostFragment.navController

        when (SharedPreferenceUtil.isPreference) {
            true -> {
                controllerNav.navigate(R.id.homeFragment)
            }
            else -> {
                controllerNav.navigate(R.id.homeFragment)
            }
        }
    }
}