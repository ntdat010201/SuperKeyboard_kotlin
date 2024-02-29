package com.example.superkeyboardkotlin

import android.annotation.SuppressLint
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

@SuppressLint("UseCompatLoadingForDrawables")
fun showImgSong(context: Context, img: Int, view: ImageView) {
    Glide.with(context).load(img)
        .placeholder(context.getDrawable(R.drawable.ic_launcher_foreground)).into(view)
}