package com.example.dz2_android_2.extension

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dz2_android_2.R

fun <T : Any> Fragment.setBackStackData(key: String, data: T, doback: Boolean) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, data)
    if (doback) {
        findNavController().navigate(R.id.detailFragment)
    }
}

fun <T : Any> Fragment.getBackStackData(key: String, result: (T) -> (Unit)) {
    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)
        ?.observe(viewLifecycleOwner) {
            result(it)
        }
}