package com.andriuswill.mesa_news.di

import com.andriuswill.mesa_news.viewmodels.HomeViewModel
import com.andriuswill.mesa_news.viewmodels.LoginViewModel
import com.andriuswill.mesa_news.viewmodels.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module(override = true) {
    viewModel {
        LoginViewModel()
    }
    viewModel {
        SignUpViewModel()
    }
    viewModel {
        HomeViewModel()
    }
}