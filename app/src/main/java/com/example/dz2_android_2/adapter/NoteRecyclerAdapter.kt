package com.example.dz2_android_2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dz2_android_2.databinding.ItemTextBinding
import com.example.dz2_android_2.model.RecyclerModel

class NoteRecyclerAdapter(private val clickListener: ((RecyclerModel) -> Unit?)? = null) :
    RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>() {

    private var list: List<RecyclerModel> = ArrayList()

    fun setList(list: List<RecyclerModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemTextBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                clickListener?.let { it1 -> it1(list[bindingAdapterPosition]) }
            }
        }

        fun onBind(recyclerModel: RecyclerModel) {
            binding.tvTitleItem.text = recyclerModel.textTitle
            binding.tvDataItem.text = recyclerModel.textData
            binding.tvDescription.text = recyclerModel.textDescription
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}