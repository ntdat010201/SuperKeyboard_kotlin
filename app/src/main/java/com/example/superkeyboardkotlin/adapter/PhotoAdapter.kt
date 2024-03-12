package com.example.superkeyboardkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.superkeyboardkotlin.R
import com.example.superkeyboardkotlin.model.ModelPhoto
import com.example.superkeyboardkotlin.showImgSong

class PhotoAdapter(
    private var mContext: Context,
    private var mListModelPhoto: List<ModelPhoto>
) : PagerAdapter() {
    override fun getCount(): Int {
        if (mListModelPhoto != null) {
            return mListModelPhoto.size
        }
        return 0
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    @Override
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        val binding = ItemCircleindicatorBinding.inflate(LayoutInflater.from(container.context),container,false)
//
//        val photo = mListModelPhoto[position]
//
//        photo.resourceId?.let { showImgSong(mContext, it, binding.imgPhoto) }
//        //add view vào ViewGroup
//        container.addView(binding.imgPhoto)
//
//        return binding.root

        val view: View = LayoutInflater.from(container.context)
            .inflate(R.layout.item_circleindicator, container, false)
        val imgPhoto: ImageView = view.findViewById(R.id.img_photo)

        val photo = mListModelPhoto[position]

        photo.resourceId?.let { showImgSong(mContext, it, imgPhoto) }
        //add view vào ViewGroup
        container.addView(view)

        return view
    }

    @Override
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //remove view
        container.removeView(`object` as View?)
    }
}