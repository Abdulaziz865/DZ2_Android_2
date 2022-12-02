package com.example.dz2_android_2.fragments.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dz2_android_2.R
import com.example.dz2_android_2.databinding.FragmentOnBoardBinding
import com.example.dz2_android_2.databinding.FragmentOnBoardPagingBinding

class OnBoardPagingFragment : Fragment() {

    private lateinit var binding : FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardPagingBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() = with(binding) {
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)) {
            0 -> {
              tvText.text = "Aziz is Smarter"
            }
            1 -> {
                tvText.text = "Aziz is Stronger"
            }
            2 -> {
                tvText.text = "Aziz is Better"
            }
        }
    }

    companion object{
        const val ARG_ONBOARD_POSITION = "onBoard"
    }

}