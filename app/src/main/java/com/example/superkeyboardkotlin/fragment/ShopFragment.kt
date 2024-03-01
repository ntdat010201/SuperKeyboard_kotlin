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
import com.example.superkeyboardkotlin.adapter.PhotoAdapter
import com.example.superkeyboardkotlin.adapter.RcvShopAdapter
import com.example.superkeyboardkotlin.databinding.FragmentShopBinding
import com.example.superkeyboardkotlin.model.Photo
import com.example.superkeyboardkotlin.model.RcvModelShop
import com.example.superkeyboardkotlin.viewmodel.PhotoViewModel
import com.example.superkeyboardkotlin.viewmodel.ShopViewModel
import java.util.*

class ShopFragment : Fragment() {
    private lateinit var binding: FragmentShopBinding

    private lateinit var shopAdapter: RcvShopAdapter
    private lateinit var shopViewModel: ShopViewModel
    private lateinit var photoAdapter: PhotoAdapter
    private lateinit var photoViewModel: PhotoViewModel

    private var mListPhoto: List<Photo>? = null
    private var mTimer: Timer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopBinding.inflate(LayoutInflater.from(requireContext()))
        initData()
        initView()
        return binding.root
    }

    private fun initData() {

    }

    private fun initView() {

        // recycleView item chủ đề trong shopFragment
        binding.rcvShop.apply {

            val gridLayoutManager = GridLayoutManager(requireContext(), 2)
            layoutManager = gridLayoutManager

            shopViewModel = ViewModelProvider(requireActivity())[ShopViewModel::class.java]
            shopViewModel.getListShopLiveData().observe(viewLifecycleOwner) { data ->

                shopAdapter = RcvShopAdapter(data as ArrayList<RcvModelShop>, requireContext())
                adapter = shopAdapter
            }
        }

        // circleIndicator viewpager trong shopFragment
        photoViewModel = ViewModelProvider(requireActivity())[PhotoViewModel::class.java]
        photoViewModel.getListPhotoLiveData().observe(viewLifecycleOwner) { data ->

            mListPhoto = data

            autoSlideImages() /*tự động chuyển ảnh sau n thời gian*/

            photoAdapter = PhotoAdapter(requireContext(), mListPhoto!!)
            binding.viewPager.adapter = photoAdapter

            binding.circleIndicator.setViewPager(binding.viewPager)
            photoAdapter.registerDataSetObserver(binding.circleIndicator.dataSetObserver)
        }
    }

    private fun autoSlideImages() {
        if (mListPhoto!!.isEmpty()) {
            return
        }
        if (mTimer == null) {
            mTimer = Timer()
        }
        mTimer!!.schedule(object : TimerTask() {
            override fun run() {
                Handler(Looper.getMainLooper()).post(Runnable {
                    var currentItem: Int = binding.viewPager.currentItem
                    val totalItem = mListPhoto!!.size - 1
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


}