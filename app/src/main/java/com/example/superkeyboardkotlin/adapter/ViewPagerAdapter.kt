package com.example.superkeyboardkotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.superkeyboardkotlin.fragment.KeyboardThemeFragment
import com.example.superkeyboardkotlin.fragment.MineFragment
import com.example.superkeyboardkotlin.fragment.SettingFragment
import com.example.superkeyboardkotlin.fragment.ShopFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private lateinit var shopFragment: ShopFragment
    private lateinit var mineFragment: MineFragment

    fun setFragments(
        shopFragment: ShopFragment,
        mineFragment: MineFragment
    ) {
        this.shopFragment = shopFragment
        this.mineFragment = mineFragment
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 ->shopFragment
            1 -> mineFragment
            else -> shopFragment
        }
    }
}