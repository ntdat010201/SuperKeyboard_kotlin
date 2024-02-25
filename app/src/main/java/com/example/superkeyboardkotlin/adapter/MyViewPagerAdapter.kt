package com.example.superkeyboardkotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.superkeyboardkotlin.fragment.KeyboardThemeFragment
import com.example.superkeyboardkotlin.fragment.setting.SettingFragment

class MyViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private lateinit var keyboardThemeFragment: KeyboardThemeFragment
    private lateinit var settingFragment: SettingFragment

    fun setFragments(
        keyboardThemeFragment: KeyboardThemeFragment,
        settingFragment: SettingFragment
    ) {
        this.keyboardThemeFragment = keyboardThemeFragment
        this.settingFragment = settingFragment
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> KeyboardThemeFragment()
            1 -> SettingFragment()
            else -> KeyboardThemeFragment()
        }
    }

}