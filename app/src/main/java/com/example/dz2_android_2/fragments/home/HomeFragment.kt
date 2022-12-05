package com.example.dz2_android_2.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dz2_android_2.databinding.FragmentHomeBinding
import com.example.dz2_android_2.fragments.util.SharedPreferenceUtil

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backStackInfo()
    }

    private fun backStackInfo() {
        if (!SharedPreferenceUtil.isPreference) {
            findNavController().popBackStack()
        }
    }
}