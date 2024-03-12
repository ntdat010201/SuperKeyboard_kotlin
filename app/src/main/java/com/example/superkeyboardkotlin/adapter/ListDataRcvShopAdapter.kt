package com.example.superkeyboardkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superkeyboardkotlin.databinding.LayoutListDataShopBinding
import com.example.superkeyboardkotlin.model.ModelListDataRcvShop
import com.example.superkeyboardkotlin.utils.Const

class ListDataRcvShopAdapter(
    private var mListData: List<ModelListDataRcvShop>, private var context: Context
) : RecyclerView.Adapter<ListDataRcvShopAdapter.ViewHolder>() {


    inner class ViewHolder(binding: LayoutListDataShopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var rcvItem = binding.rcvItemShop
    }

    @Override
    override fun getItemViewType(position: Int): Int {
        return mListData[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutListDataShopBinding.inflate(
                LayoutInflater.from(context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return mListData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (Const.TYPE_TOPIC == holder.itemViewType) {

            val linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            holder.rcvItem.layoutManager = linearLayoutManager
            holder.rcvItem.isFocusable = false


            val topicShopAdapter = TopicShopAdapter(mListData[position].listTopic)
            holder.rcvItem.adapter = topicShopAdapter
        } else if (Const.TYPE_CATEGORY == holder.itemViewType) {
            val gridLayoutManager =
                GridLayoutManager(context, 2)
            holder.rcvItem.layoutManager = gridLayoutManager
            holder.rcvItem.isFocusable = false

            val categoryShopAdapter = CategoryShopAdapter(mListData[position].listCategory)
            holder.rcvItem.adapter = categoryShopAdapter
        }


    }

}