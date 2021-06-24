package com.vannhat.androidbase

import android.app.Application
import com.vannhat.androidbase.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val modules = listOf(
            appModule,
            networkModule,
            repositoryModule,
            mapperModule,
            useCaseModule,
            viewModelModule
        )

        startKoin {
            androidContext(this@MainApplication)
            modules(modules)
        }
    }

}
