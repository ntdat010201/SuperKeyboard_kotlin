package com.example.superkeyboardkotlin.fragment.setting.viewmodel

import android.app.Dialog
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superkeyboardkotlin.R
import com.example.superkeyboardkotlin.fragment.setting.model.Feature
import com.example.superkeyboardkotlin.fragment.setting.model.GroupFeatures

class GroupFeaturesViewModel: ViewModel() {

    var listGroupFeatures: MutableLiveData<ArrayList<GroupFeatures>> = MutableLiveData<ArrayList<GroupFeatures>>()
    var isShowKeyboard: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)

    fun initData() {
        listGroupFeatures.value = ArrayList()
    }

    fun showKeyBoardLayout() {
        isShowKeyboard.value = true
    }


}