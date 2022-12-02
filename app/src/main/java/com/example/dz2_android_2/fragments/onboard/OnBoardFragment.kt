package com.example.dz2_android_2.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dz2_android_2.adapters.OnBoardViewPagerAdapter
import com.example.dz2_android_2.databinding.FragmentOnBoardBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardFragment : Fragment() {

    private lateinit var binding : FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardBinding.inflate(inflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        clickButton()

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ ->
            //Some implementation
        }.attach()
    }

    private fun initialize() {
        binding.viewPager.adapter = OnBoardViewPagerAdapter(this@OnBoardFragment)
    }

    private fun clickButton() = with(binding.viewPager) {
       binding.tvNext.setOnClickListener{
           if (currentItem < 3){
               setCurrentItem(currentItem + 1 , true)
           }
       }
    }
}