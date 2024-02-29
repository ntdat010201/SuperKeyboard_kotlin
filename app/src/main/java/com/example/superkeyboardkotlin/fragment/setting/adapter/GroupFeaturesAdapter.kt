package com.example.superkeyboardkotlin.fragment.setting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superkeyboardkotlin.databinding.ItemGroupFeaturesBinding
import com.example.superkeyboardkotlin.fragment.setting.model.GroupFeatures

class GroupFeaturesAdapter(private val context: Context, private val listGroupFeatures: ArrayList<GroupFeatures>): RecyclerView.Adapter<GroupFeaturesAdapter.GroupFeaturesViewHolder>() {

    class GroupFeaturesViewHolder(private val binding: ItemGroupFeaturesBinding): RecyclerView.ViewHolder(binding.root){
        fun initData(context: Context, data: GroupFeatures) {
            binding.groupName.text = data.name
            binding.groupFeatures.apply {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = FeaturesAdapter(context, data.features)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupFeaturesViewHolder {
        val binding = ItemGroupFeaturesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GroupFeaturesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listGroupFeatures.size
    }

    override fun onBindViewHolder(holder: GroupFeaturesViewHolder, position: Int) {
        val data = listGroupFeatures[position]
        holder.initData(context, data)
    }

}