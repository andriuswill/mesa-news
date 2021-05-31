package com.andriuswill.mesa_news.api

import com.andriuswill.mesa_news.data.*
import io.reactivex.rxjava3.core.Single
import okhttp3.ResponseBody
import retrofit2.http.*

interface Api {

    @POST("/$version/client/auth/signin")
    fun login(
        @Body body: LoginRequest
    ): Single<TokenResponse>

            @POST("/$version/client/auth/signup")
    fun signup(
        @Body body: SignUpRequest
    ): Single<TokenResponse>

    @GET("/$version/client/news")
    fun getNews(
        @Header("Authorization") token: String,
        @Query("current_page") currentPage: Int? = null,
        @Query("per_page") perPage: Int? = null,
        @Query("published_at") publishedAt: Int? = null
    ): Single<NewsResponse>

    @GET("/$version/client/news/highlights")
    fun getHighlights(
        @Header("Authorization") token: String,
    ): Single<HighLightsResponse>


    companion object {
        const val version = "v1"
        fun instance(builder: ApiBuilder): Api =
            builder.retrofit().create(Api::class.java)
    }

}