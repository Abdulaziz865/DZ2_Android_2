package com.example.dz2_android_2.fragments.onboards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.dz2_android_2.R
import com.example.dz2_android_2.adapter.OnBoardViewPagerAdapter
import com.example.dz2_android_2.databinding.FragmentOnBoardBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        clickButton()
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ ->
            //Some implementation
        }.attach()
        onPage()
        clickHome()
    }

    private fun clickHome() {
        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardFragment_to_homeFragment2)
        }
    }

    private fun initialize() {
        binding.viewPager.adapter = OnBoardViewPagerAdapter(this@OnBoardFragment)
    }

    private fun clickButton() = with(binding.viewPager) {
        binding.btnNext.setOnClickListener {
            if (currentItem < 2) {
                setCurrentItem(currentItem + 1, true)
            }
        }
    }

    private fun onPage() = with(binding) {
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        btnNext.isVisible = true
                        btnHome.isVisible = false
                    }
                    1 -> {
                        btnNext.isVisible = true
                        btnHome.isVisible = false
                    }
                    2 -> {
                        btnNext.isVisible = false
                        btnHome.isVisible = true
                    }
                }
                super.onPageSelected(position)
            }
        })
    }
}