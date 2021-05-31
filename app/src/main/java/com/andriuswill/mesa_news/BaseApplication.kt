package com.andriuswill.mesa_news

import androidx.multidex.MultiDexApplication
import com.andriuswill.mesa_news.di.Injector
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(Injector.init())
        }
    }

}