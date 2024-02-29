package com.example.superkeyboardkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superkeyboardkotlin.databinding.ItemShopBinding
import com.example.superkeyboardkotlin.model.RcvModelShop

class RcvShopAdapter(
    private var topics: ArrayList<RcvModelShop>,
    private var context: Context
) : RecyclerView.Adapter<RcvShopAdapter.MyHolder>() {

    inner class MyHolder(binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root) {
        var imgKeyboard = binding.imgKeyboard
        var nameKeyboard = binding.nameKeyboard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(ItemShopBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return topics.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.imgKeyboard.setImageResource(topics[position].image)
        holder.nameKeyboard.text = topics[position].nameKeyboard
    }
}