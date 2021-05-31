package com.andriuswill.mesa_news.di

import com.andriuswill.mesa_news.api.Api
import com.andriuswill.mesa_news.api.ApiBuilder
import com.andriuswill.mesa_news.api.Repository
import com.andriuswill.mesa_news.api.RepositoryImpl
import com.andriuswill.mesa_news.viewmodels.HomeViewModel
import com.andriuswill.mesa_news.viewmodels.LoginViewModel
import com.andriuswill.mesa_news.viewmodels.SignUpViewModel
import io.reactivex.rxjava3.core.Single
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module(override = true) {
    viewModel {
        LoginViewModel(get())
    }
    viewModel {
        SignUpViewModel(get())
    }
    viewModel {
        HomeViewModel(get())
    }
}

val apiModule = module(override = true) {
    single {
        ApiBuilder()
    }
    single {
        Api.instance(get())
    }
    single<Repository> {
        RepositoryImpl(get())
    }
}
