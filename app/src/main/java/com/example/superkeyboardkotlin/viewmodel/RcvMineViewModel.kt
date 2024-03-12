package com.example.superkeyboardkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superkeyboardkotlin.R
import com.example.superkeyboardkotlin.model.ModelMine

class RcvMineViewModel : ViewModel() {

    private var mListModelMineLiveData : MutableLiveData<List<ModelMine>> = MutableLiveData()
    private var mListModelMine : ArrayList<ModelMine> = ArrayList()

    init {
        mListModelMine.add(ModelMine(R.drawable.image_test,"name keyboard 1"))
        mListModelMine.add(ModelMine(R.drawable.image_test,"name keyboard 2"))
        mListModelMine.add(ModelMine(R.drawable.image_test,"name keyboard 3"))
        mListModelMine.add(ModelMine(R.drawable.image_test,"name keyboard 4"))
        mListModelMine.add(ModelMine(R.drawable.image_test,"name keyboard 5"))
        mListModelMine.add(ModelMine(R.drawable.image_test,"name keyboard 6"))
        mListModelMine.add(ModelMine(R.drawable.image_test,"name keyboard 7"))
        mListModelMine.add(ModelMine(R.drawable.image_test,"name keyboard 8"))
        mListModelMine.add(ModelMine(R.drawable.image_test,"name keyboard 9"))

        mListModelMineLiveData.value = mListModelMine
    }

    fun getListMineLiveData() : MutableLiveData<List<ModelMine>>{
        return mListModelMineLiveData
    }
}