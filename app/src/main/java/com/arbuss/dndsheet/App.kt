package com.arbuss.dndsheet

import android.app.Application
import com.arbuss.data.di.dataModule
import com.arbuss.ui.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)

            modules(listOf(dataModule, uiModule))
        }
    }
}
