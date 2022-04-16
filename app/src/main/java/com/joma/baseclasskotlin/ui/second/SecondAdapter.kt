package com.joma.baseclasskotlin.ui.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.joma.baseclasskotlin.databinding.SelectedItemBinding

class SecondAdapter : RecyclerView.Adapter<SecondAdapter.SecondViewHolder>() {
    private var selectList = arrayListOf<String>()

    fun setSelectList(selectList: ArrayList<String>) {
        this.selectList = selectList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        val binding: SelectedItemBinding =
            SelectedItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return SecondViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.onBind(selectList[position])
    }

    override fun getItemCount(): Int {
        return selectList.size
    }

    class SecondViewHolder(private val binding: SelectedItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(s: String) {
            Glide.with(binding.root).load(s).centerCrop().into(binding.imgSelectItem)
        }
    }
}