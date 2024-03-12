package com.example.superkeyboardkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superkeyboardkotlin.databinding.ItemCategoryKeyboardShopBinding
import com.example.superkeyboardkotlin.model.ModelCategory

class CategoryShopAdapter(
    private val mListCategory: List<ModelCategory>
) : RecyclerView.Adapter<CategoryShopAdapter.ViewHolder>() {
    inner class ViewHolder(binding: ItemCategoryKeyboardShopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imageKeyboard = binding.imgCategoryKeyboard
        val nameKeyboard = binding.nameCategoryKeyboard
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCategoryKeyboardShopBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mListCategory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageKeyboard.setImageResource(mListCategory[position].imageKeyboard)
        holder.nameKeyboard.text = mListCategory[position].nameKeyboard
    }

}