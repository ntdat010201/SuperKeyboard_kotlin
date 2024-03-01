package com.example.superkeyboardkotlin

import android.os.Bundle
import android.view.LayoutInflater
import com.example.foodappkotlin.base.BaseActivity
import com.example.superkeyboardkotlin.adapter.MyViewPagerAdapter
import com.example.superkeyboardkotlin.databinding.ActivityMainBinding
import com.example.superkeyboardkotlin.fragment.KeyboardThemeFragment
import com.example.superkeyboardkotlin.fragment.setting.SettingFragment
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    private val keyboardThemeFragment by inject<KeyboardThemeFragment>()
    private val settingFragment by inject<SettingFragment>()

    private var myViewPagerAdapter: MyViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initData()
        initView()
        initListener()
    }

    private fun initData() {
        myViewPagerAdapter = MyViewPagerAdapter(this)
        //  myViewPagerAdapter!!.setFragments(keyboardThemeFragment, settingFragment)
          myViewPagerAdapter!!.setFragments(keyboardThemeFragment, settingFragment)

        /* khởi tạo và set viewpager2 tablayout*/
        binding.viewPager.offscreenPageLimit = 2
        binding.viewPager.isUserInputEnabled = false
        binding.viewPager.adapter = myViewPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.setIcon(R.drawable.ic_home)
                else -> tab.setIcon(R.drawable.ic_settings)
            }
        }.attach()
    }

    private fun initView() {
    }

    private fun initListener() {}
}