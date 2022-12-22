package com.example.dz2_android_2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dz2_android_2.databinding.ItemMessageBinding
import com.example.dz2_android_2.ui.model.ChatModel

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ViewHolderChat>() {

    private var list: List<ChatModel> = ArrayList()

    fun setList(list: ArrayList<ChatModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolderChat(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(chatModel: ChatModel) {
            binding.tvMessage.text = chatModel.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderChat {
        return ViewHolderChat(
            ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderChat, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}