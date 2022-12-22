package com.example.dz2_android_2.ui.fragments.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dz2_android_2.databinding.FragmentChatBinding
import com.example.dz2_android_2.ui.adapter.ChatAdapter
import com.example.dz2_android_2.ui.model.ChatModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ChatFragment : Fragment() {

    private lateinit var binding: FragmentChatBinding
    private val chatAdapter = ChatAdapter()
    private lateinit var model: ChatModel
    private val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setUpListener()
        getCollectionData()
    }

    private fun initialize() {
        binding.rvListOfMessage.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = chatAdapter
        }
    }

    private fun setUpListener() = with(binding) {
        btnAdd.setOnClickListener {
            val user = hashMapOf(
                "name" to binding.etMessage.text.toString()
            )
            db.collection("user").add(user).addOnSuccessListener {}
        }
    }

    private fun getCollectionData() {
        val collectionRef = db.collection("user")
        collectionRef.addSnapshotListener { value, _ ->
            if (value != null) {
                var list = ArrayList<ChatModel>()
                for (data in value) {
                    data.getString("name")?.let {
                        model = ChatModel(it)
                        list.add(model)
                    }
                }
                chatAdapter.setList(list)
            }
        }
    }
}
