package com.example.superkeyboardkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superkeyboardkotlin.R
import com.example.superkeyboardkotlin.model.ModelCategory
import com.example.superkeyboardkotlin.model.ModelListDataRcvShop
import com.example.superkeyboardkotlin.model.ModelTopic
import com.example.superkeyboardkotlin.utils.Const

class DataRcvShopViewModel : ViewModel() {
    private var mListModelRcvShopLiveData: MutableLiveData<List<ModelListDataRcvShop>> =
        MutableLiveData()
    private var mListDataRcv: ArrayList<ModelListDataRcvShop> = ArrayList()

    init {
        val listTopic: ArrayList<ModelTopic> = ArrayList()
        listTopic.add(ModelTopic("Topic 1"))

        val listCategory: ArrayList<ModelCategory> = ArrayList()
        listCategory.add(ModelCategory(R.drawable.image_test, "key board 1"))
        listCategory.add(ModelCategory(R.drawable.image_test2, "key board 2"))
        listCategory.add(ModelCategory(R.drawable.image_test3, "key board 3"))
        listCategory.add(ModelCategory(R.drawable.image_test, "key board 1"))
        listCategory.add(ModelCategory(R.drawable.image_test2, "key board 2"))
        listCategory.add(ModelCategory(R.drawable.image_test3, "key board 3"))

        mListDataRcv.add(ModelListDataRcvShop(Const.TYPE_TOPIC, listTopic, emptyList()))
        mListDataRcv.add(ModelListDataRcvShop(Const.TYPE_CATEGORY, emptyList(), listCategory))

        mListDataRcv.add(ModelListDataRcvShop(Const.TYPE_TOPIC, listTopic, emptyList()))
        mListDataRcv.add(ModelListDataRcvShop(Const.TYPE_CATEGORY, emptyList(), listCategory))

        mListDataRcv.add(ModelListDataRcvShop(Const.TYPE_TOPIC, listTopic, emptyList()))
        mListDataRcv.add(ModelListDataRcvShop(Const.TYPE_CATEGORY, emptyList(), listCategory))

        mListModelRcvShopLiveData.value = mListDataRcv
    }

    fun getListRcvShopLiveData(): MutableLiveData<List<ModelListDataRcvShop>> {
        return mListModelRcvShopLiveData
    }
}