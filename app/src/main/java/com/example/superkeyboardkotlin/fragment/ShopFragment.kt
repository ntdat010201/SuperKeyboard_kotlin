package com.example.superkeyboardkotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.superkeyboardkotlin.adapter.RcvShopAdapter
import com.example.superkeyboardkotlin.databinding.FragmentShopBinding
import com.example.superkeyboardkotlin.model.RcvModelShop
import com.example.superkeyboardkotlin.viewmodel.ShopViewModel

class ShopFragment : Fragment() {
    private lateinit var binding: FragmentShopBinding

    private lateinit var shopAdapter: RcvShopAdapter
    private lateinit var shopViewModel: ShopViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopBinding.inflate(LayoutInflater.from(requireContext()))
        initData()
        return binding.root
    }

    private fun initData() {
        val gridLayoutManager = GridLayoutManager(requireContext(),2)
        binding.rcvShop.layoutManager = gridLayoutManager

        shopViewModel = ViewModelProvider(this)[ShopViewModel::class.java]
        shopViewModel.getListShopLiveData().observe(viewLifecycleOwner) { data ->

            shopAdapter = RcvShopAdapter(data as ArrayList<RcvModelShop>, requireContext())
            binding.rcvShop.adapter = shopAdapter
        }
    }
}