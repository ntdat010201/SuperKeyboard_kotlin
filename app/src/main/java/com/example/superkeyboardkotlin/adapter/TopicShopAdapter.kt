package com.example.superkeyboardkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superkeyboardkotlin.databinding.ItemTopicShopBinding
import com.example.superkeyboardkotlin.model.ModelTopic

class TopicShopAdapter(
    private val mListTopic : List<ModelTopic>
) : RecyclerView.Adapter<TopicShopAdapter.ViewHolder>() {

   inner class ViewHolder(binding: ItemTopicShopBinding) : RecyclerView.ViewHolder(binding.root){
       val nameTopicShop = binding.nameTopicShop
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ItemTopicShopBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return mListTopic.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTopicShop.text = mListTopic[position].nameTopic
    }
}