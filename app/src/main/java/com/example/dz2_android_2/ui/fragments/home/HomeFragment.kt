package com.example.dz2_android_2.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dz2_android_2.App
import com.example.dz2_android_2.R
import com.example.dz2_android_2.ui.adapter.RecyclerAdapter
import com.example.dz2_android_2.databinding.FragmentHomeBinding
import com.example.dz2_android_2.ui.model.RecyclerModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var recyclerAdapter = RecyclerAdapter()
    private var list: ArrayList<RecyclerModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpClickListener()
        getData()
    }

    private fun initialize() {
        recyclerAdapter = RecyclerAdapter(this::onClickListener)
        binding.rvListOfText.apply{
            adapter = recyclerAdapter }
    }

    private fun setUpClickListener() = with(binding) {
        btnAddText.setOnClickListener {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                    null, false
                )
            )
        }
        viewGridManager.setOnClickListener {
            rvListOfText.layoutManager = GridLayoutManager(requireContext() ,2)
            viewGridManager.isInvisible = true
            viewLinearManager.isVisible = true
        }
        viewLinearManager.setOnClickListener {
            rvListOfText.layoutManager = LinearLayoutManager(requireContext())
            viewLinearManager.isInvisible = true
            viewGridManager.isVisible = true
        }
        chatReplace.setOnClickListener {
            findNavController().navigate(R.id.chatFragment)
        }
    }

    private fun onClickListener(model: RecyclerModel) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                model, true
            )
        )
    }

    private fun getData() {
        App.getInstance()?.noteDao()?.getAll()?.observe(viewLifecycleOwner) {
            recyclerAdapter.setList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        list.clear()
    }
}