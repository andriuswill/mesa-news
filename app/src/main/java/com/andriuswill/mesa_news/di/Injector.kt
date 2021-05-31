package com.andriuswill.mesa_news.di

import org.koin.core.module.Module

object Injector {

    fun init() = arrayListOf<Module>().apply {
        add(viewModelModule)
        add(apiModule)
    }

}