package com.example.superkeyboardkotlin.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.superkeyboardkotlin.adapter.ViewPagerAdapter
import com.example.superkeyboardkotlin.databinding.FragmentKeyboardThemeBinding
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.ext.android.inject

class KeyboardThemeFragment : Fragment() {
    private lateinit var binding: FragmentKeyboardThemeBinding

    private val shopFragment by inject<ShopFragment>()
    private val mineFragment by inject<MineFragment>()

    private var viewPagerAdapter: ViewPagerAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentKeyboardThemeBinding.inflate(LayoutInflater.from(requireContext()))
        initData()
        initView()
        initListener()
        return binding.root
    }

    private fun initData() {
        viewPagerAdapter = ViewPagerAdapter(requireActivity())
        viewPagerAdapter!!.setFragments(shopFragment, mineFragment)

//         khởi tạo và set viewpager2 tablayout
        binding.viewPager.offscreenPageLimit = 2

        binding.viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Cửa hàng"
                else -> tab.text = " Của tôi"
            }
        }.attach()
    }

    private fun initView() {
    }

    private fun initListener() {
    }

}