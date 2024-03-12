package com.example.superkeyboardkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superkeyboardkotlin.databinding.ItemMineBinding
import com.example.superkeyboardkotlin.model.ModelMine

class RcvMineAdapter(
    private val mListMine : List<ModelMine>
) : RecyclerView.Adapter<RcvMineAdapter.ViewHolder>() {

    inner class ViewHolder(binding : ItemMineBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageMine = binding.imgMineKeyboard
        val nameMine = binding.nameMineKeyboard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemMineBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return mListMine.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageMine.setImageResource(mListMine[position].imageKeyboard)
        holder.nameMine.text = mListMine[position].nameKeyboard
    }
}