package com.andriuswill.mesa_news

import android.app.Application
import com.andriuswill.mesa_news.di.Injector
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(Injector.init())
        }
    }

}