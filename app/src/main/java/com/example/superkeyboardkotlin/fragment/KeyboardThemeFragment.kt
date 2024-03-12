package com.example.superkeyboardkotlin.fragment

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.palette.graphics.Palette
import com.example.superkeyboardkotlin.R
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
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
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

        for (i in 0..1) {
            val textView = LayoutInflater.from(requireContext()).inflate(R.layout.tab_title, null)
            binding.tabLayout.getTabAt(i)?.customView = textView
        }
    }

    private fun initView() {
//        setToolbar()
//        setTabLayoutAnimation()

    }

    private fun initListener() {
    }

    private fun setToolbar() {
        (activity as? AppCompatActivity)?.setSupportActionBar(binding.toolbar)
        if ((activity as? AppCompatActivity)?.supportActionBar != null) {
            (activity as? AppCompatActivity)?.supportActionBar!!.title = "tetete"
            (activity as? AppCompatActivity)?.supportActionBar!!.setIcon(R.drawable.ic_search)
        }
    }

    private fun setTabLayoutAnimation() {
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.image_test)
        Palette.from(bitmap).generate(Palette.PaletteAsyncListener { palette ->

            val myColor: Int =
                palette!!.getVibrantColor(resources.getColor(androidx.appcompat.R.color.error_color_material_dark))
            val myColorDark: Int =
                palette.getVibrantColor(resources.getColor(androidx.appcompat.R.color.foreground_material_light))
            binding.collapsingToolbarLayout.setContentScrimColor(myColor)
            binding.collapsingToolbarLayout.setStatusBarScrimColor(myColorDark)
        })
    }


}