package com.example.superkeyboardkotlin.application

import android.app.Application
import android.content.Context
import com.example.foodappkotlin.di.listModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class KeyboardApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin(this)
    }

    private fun setupKoin(context: Context) {
        startKoin {
            androidContext(context)
            modules(listModule)
        }
    }
}