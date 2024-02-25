package com.example.superkeyboardkotlin.fragment.setting.viewmodel

import android.content.Context
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superkeyboardkotlin.R
import com.example.superkeyboardkotlin.fragment.setting.model.Feature
import com.example.superkeyboardkotlin.fragment.setting.model.GroupFeatures

class GroupFeaturesViewModel: ViewModel() {

    var listGroupFeaturesLiveData = MutableLiveData<ArrayList<GroupFeatures>>()



}