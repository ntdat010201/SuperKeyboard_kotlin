package com.example.superkeyboardkotlin.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.superkeyboardkotlin.R
import com.example.superkeyboardkotlin.databinding.FragmentShopBinding

class ShopFragment : Fragment() {
    private lateinit var binding :FragmentShopBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShopBinding.inflate(LayoutInflater.from(requireContext()))
        initData()
        return binding.root
    }

    private fun initData() {

    }
}