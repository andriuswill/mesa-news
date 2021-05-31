package com.andriuswill.mesa_news.data

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("pagination") val pagination: Pagination,
    @SerializedName("data") val data: ArrayList<News>
)