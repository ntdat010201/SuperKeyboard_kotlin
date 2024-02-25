package com.example.foodappkotlin.di

import com.example.superkeyboardkotlin.MainActivity
import com.example.superkeyboardkotlin.fragment.KeyboardThemeFragment
import com.example.superkeyboardkotlin.fragment.SettingFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.dsl.module

val mainActivity = module {
    scope<MainActivity> {
        fragment { KeyboardThemeFragment() }
        fragment { SettingFragment() }
    }
}
val listModule = listOf(
    mainActivity
)
