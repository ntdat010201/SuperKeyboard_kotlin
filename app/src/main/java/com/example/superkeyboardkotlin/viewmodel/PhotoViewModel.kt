package com.example.superkeyboardkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superkeyboardkotlin.R
import com.example.superkeyboardkotlin.model.ModelPhoto

class PhotoViewModel : ViewModel() {
    private var mListModelPhotoLiveData: MutableLiveData<List<ModelPhoto>> = MutableLiveData()
    private var mListModelPhoto: ArrayList<ModelPhoto> = ArrayList()

    init {
        mListModelPhoto.add(ModelPhoto(R.drawable.image_test))
        mListModelPhoto.add(ModelPhoto(R.drawable.image_test2))
        mListModelPhoto.add(ModelPhoto(R.drawable.image_test3))

        mListModelPhotoLiveData.value = mListModelPhoto
    }

    fun getListPhotoLiveData(): MutableLiveData<List<ModelPhoto>> {
        return mListModelPhotoLiveData
    }
}