package com.andriuswill.mesa_news.api

import com.andriuswill.mesa_news.data.LoginRequest
import com.andriuswill.mesa_news.data.SignUpRequest
import com.andriuswill.mesa_news.extensions.saveMainThread

class RepositoryImpl(
    private val api: Api
): Repository {

    override fun login(
        body: LoginRequest
    ) = api.login(
        body = body
    ).saveMainThread()

    override fun signup(
        body: SignUpRequest
    ) = api.signup(
        body = body
    ).saveMainThread()

    override fun getNews(
        currentPage: Int?,
        perPage: Int?,
        publishedAt: Int?
    ) = api.getNews(
        token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MjU5LCJlbWFpbCI6ImRpbWFzLmdhYnJpZWxAenJvYmFuay5jb20uYnIifQ.a3j7sRx8FIedZCfDGLocduOYpcibfIenX7TVJjv6Sis",
        currentPage = currentPage,
        perPage = perPage,
        publishedAt = publishedAt
    ).saveMainThread()

    override fun getHighlights() = api.getHighlights(
        token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MjU5LCJlbWFpbCI6ImRpbWFzLmdhYnJpZWxAenJvYmFuay5jb20uYnIifQ.a3j7sRx8FIedZCfDGLocduOYpcibfIenX7TVJjv6Sis"
    ).saveMainThread()

}