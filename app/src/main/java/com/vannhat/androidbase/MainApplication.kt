package com.vannhat.androidbase

import android.app.Application
import com.vannhat.androidbase.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val modules = listOf(
            appModule,
            networkModule,
            repositoryModule,
            mapperModule,
            useCaseModule
        )

        startKoin {
            androidContext(this@MainApplication)
            modules(modules)
        }
    }

}
