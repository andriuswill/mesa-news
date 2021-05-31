package com.andriuswill.mesa_news.api

import com.andriuswill.mesa_news.data.*
import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody

interface Repository {

    fun login(
        body: LoginRequest
    ): Single<TokenResponse>

    fun signup(
        body: SignUpRequest
    ): Single<TokenResponse>

    fun getNews(
        currentPage: Int? = null,
        perPage: Int? = null,
        publishedAt: Int? = null
    ): Single<NewsResponse>

    fun getHighlights(): Single<HighLightsResponse>
}