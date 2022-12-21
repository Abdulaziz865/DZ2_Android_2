package com.example.dz2_android_2.ui.fragments.detail

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dz2_android_2.App
import com.example.dz2_android_2.databinding.FragmentDetailBinding
import com.example.dz2_android_2.ui.model.RecyclerModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var model: RecyclerModel
    private val argsNavigation by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeTextSaveButton()
        setUpClickListener()
        getData()
    }

    private fun changeTextSaveButton() {
        if (argsNavigation.isUpdate) {
            binding.btnSaveRoom.text = "Обновить"
        } else {
            binding.btnSaveRoom.text = "Готово"
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setUpClickListener() = with(binding) {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd MMMM")
        val formatted = current.format(formatter)
        binding.tvData.text = formatted

        btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
        btnSaveRoom.setOnClickListener {
            if (!argsNavigation.isUpdate) {
                val clockInfo = binding.tvClock.text.toString()
                val date = "$formatted $clockInfo"
                val et = editText.text.toString()
                val title = editTitle.text.toString()
                App.getInstance()?.noteDao()?.insertNote(RecyclerModel(title, et, date))
                findNavController().navigateUp()
            } else {
                val clockInfo = binding.tvClock.text.toString()
                val etTitle = binding.editTitle.text.toString()
                val etDescription = binding.editText.text.toString()
                argsNavigation.model?.textTitle = etTitle
                argsNavigation.model?.textDescription = etDescription
                argsNavigation.model?.textData = "$formatted $clockInfo"
                model = argsNavigation.model!!
                App.getInstance()?.noteDao()?.upDateUser(model)
                findNavController().navigateUp()
            }
        }
        editText.addTextChangedListener {
            btnSaveRoom.isVisible = editText.text.isNotEmpty()
        }
    }

    private fun getData() {
        if (argsNavigation.isUpdate) {
            binding.editTitle.setText(argsNavigation.model?.textTitle)
            binding.editText.setText(argsNavigation.model?.textDescription)
        }
    }
}