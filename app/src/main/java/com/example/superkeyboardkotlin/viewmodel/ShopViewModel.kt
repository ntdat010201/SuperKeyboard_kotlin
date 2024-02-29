package com.example.superkeyboardkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superkeyboardkotlin.R
import com.example.superkeyboardkotlin.model.RcvModelShop

class ShopViewModel : ViewModel() {

    private var mListShopLiveData: MutableLiveData<List<RcvModelShop>> = MutableLiveData()
    private var mListShop: ArrayList<RcvModelShop> = ArrayList()

    init {
        mListShop.add(RcvModelShop(R.drawable.ic_launcher_background, "namenamename"))
        mListShop.add(RcvModelShop(R.drawable.ic_launcher_background, "namenamename"))
        mListShop.add(RcvModelShop(R.drawable.ic_launcher_background, "namenamename"))
        mListShop.add(RcvModelShop(R.drawable.ic_launcher_background, "namenamename"))
        mListShop.add(RcvModelShop(R.drawable.ic_launcher_background, "namenamename"))
        mListShop.add(RcvModelShop(R.drawable.ic_launcher_background, "namenamename"))

        mListShopLiveData.value = mListShop
    }

    fun getListShopLiveData(): MutableLiveData<List<RcvModelShop>> {
        return mListShopLiveData
    }
}