package com.example.superkeyboardkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superkeyboardkotlin.R
import com.example.superkeyboardkotlin.model.Photo

class PhotoViewModel : ViewModel() {
    private var mListPhotoLiveData: MutableLiveData<List<Photo>> = MutableLiveData()
    private var mListPhoto: ArrayList<Photo> = ArrayList()

    init {
        mListPhoto.add(Photo(R.drawable.image_test))
        mListPhoto.add(Photo(R.drawable.image_test2))
        mListPhoto.add(Photo(R.drawable.image_test3))

        mListPhotoLiveData.value = mListPhoto
    }

    fun getListPhotoLiveData(): MutableLiveData<List<Photo>> {
        return mListPhotoLiveData
    }
}