package com.example.superkeyboardkotlin.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superkeyboardkotlin.adapter.ListDataRcvShopAdapter
import com.example.superkeyboardkotlin.adapter.PhotoAdapter
import com.example.superkeyboardkotlin.databinding.FragmentShopBinding
import com.example.superkeyboardkotlin.model.ModelPhoto
import com.example.superkeyboardkotlin.viewmodel.DataRcvShopViewModel
import com.example.superkeyboardkotlin.viewmodel.PhotoViewModel
import java.util.*

class ShopFragment : Fragment() {
    private lateinit var binding: FragmentShopBinding

    private lateinit var photoAdapter: PhotoAdapter
    private lateinit var photoViewModel: PhotoViewModel
    private var mListModelPhoto: List<ModelPhoto>? = null
    private var mTimer: Timer? = null

    private lateinit var listDataRcvShopAdapter: ListDataRcvShopAdapter
    private lateinit var dataRcvShopViewModel: DataRcvShopViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopBinding.inflate(LayoutInflater.from(requireContext()))
        initData()
        initView()
        initListener()
        return binding.root
    }
    private fun initData() {}

    private fun initView() {

        // recycleView item chủ đề trong shopFragment
        binding.rcvShop.apply {
            val linearLayoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            layoutManager = linearLayoutManager
            isFocusable = false

            dataRcvShopViewModel =
                ViewModelProvider(requireActivity())[DataRcvShopViewModel::class.java]
            dataRcvShopViewModel.getListRcvShopLiveData().observe(viewLifecycleOwner) { data ->

                listDataRcvShopAdapter = ListDataRcvShopAdapter(data, requireContext())
                adapter = listDataRcvShopAdapter
            }
        }

        // circleIndicator viewpager trong shopFragment
        photoViewModel = ViewModelProvider(requireActivity())[PhotoViewModel::class.java]
        photoViewModel.getListPhotoLiveData().observe(viewLifecycleOwner) { data ->

            mListModelPhoto = data

            autoSlideImages() /*tự động chuyển ảnh sau n thời gian*/

            photoAdapter = PhotoAdapter(requireContext(), mListModelPhoto!!)
            binding.viewPager.adapter = photoAdapter

            binding.circleIndicator.setViewPager(binding.viewPager)
            photoAdapter.registerDataSetObserver(binding.circleIndicator.dataSetObserver)
        }
    }

    private fun autoSlideImages() {
        if (mListModelPhoto!!.isEmpty()) {
            return
        }
        if (mTimer == null) {
            mTimer = Timer()
        }
        mTimer!!.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post(Runnable {
                    var currentItem: Int = binding.viewPager.currentItem
                    val totalItem = mListModelPhoto!!.size - 1
                    if (currentItem < totalItem) {
                        currentItem++
                        binding.viewPager.currentItem = currentItem
                    } else {
                        binding.viewPager.currentItem = 0
                    }
                })
            }
        }, 500, 3000)
    }

    @Override
    override fun onDestroy() {
        super.onDestroy()

        // hủy Timer khi activity,fragment bị hủy
        if (mTimer != null) {
            mTimer!!.cancel()
            mTimer = null
        }
    }

    private fun initListener() {
    }


}