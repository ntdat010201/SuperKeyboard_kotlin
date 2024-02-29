package com.example.foodappkotlin.di

import com.example.superkeyboardkotlin.MainActivity
import com.example.superkeyboardkotlin.fragment.KeyboardThemeFragment
import com.example.superkeyboardkotlin.fragment.MineFragment
import com.example.superkeyboardkotlin.fragment.ShopFragment
import com.example.superkeyboardkotlin.fragment.setting.SettingFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val mainActivity = module {

    scope<MainActivity> {
    }

    fragment { KeyboardThemeFragment() }
    fragment { SettingFragment() }
    fragment { ShopFragment() }
    fragment { MineFragment() }

}
val listModule = listOf(
    mainActivity
)