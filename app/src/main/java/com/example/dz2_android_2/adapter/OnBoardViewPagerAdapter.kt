package com.example.dz2_android_2.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dz2_android_2.fragments.onboards.OnBoardPagingFragment

class OnBoardViewPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int) = OnBoardPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(OnBoardPagingFragment.ARG_ONBOARD_POSITION, position)
        }
    }
}