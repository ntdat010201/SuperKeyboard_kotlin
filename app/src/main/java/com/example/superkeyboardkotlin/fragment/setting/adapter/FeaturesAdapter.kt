package com.example.superkeyboardkotlin.fragment.setting.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.example.superkeyboardkotlin.databinding.ItemFeatureBinding
import com.example.superkeyboardkotlin.fragment.setting.model.Feature

class FeaturesAdapter(private val context: Context, private val listFeatures: ArrayList<Feature>):
    RecyclerView.Adapter<FeaturesAdapter.FeaturesViewHolder>() {

    class FeaturesViewHolder(val binding: ItemFeatureBinding): RecyclerView.ViewHolder(binding.root){
        fun initData(data: Feature) {
            binding.icFeature.setImageResource(data.img)
            binding.featureName.text = data.name
            binding.featureDescription.text = data.description
            if (data.description.isEmpty()){
                binding.featureDescription.visibility = GONE
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturesViewHolder {
        val binding = ItemFeatureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeaturesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listFeatures.size
    }

    override fun onBindViewHolder(holder: FeaturesViewHolder, position: Int) {
        val data = listFeatures[position]
        holder.initData(data)
    }
}