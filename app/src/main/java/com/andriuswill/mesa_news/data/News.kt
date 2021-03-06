package com.andriuswill.mesa_news.data

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("content") val content: String,
    @SerializedName("author") val author: String,
    @SerializedName("published_at") val publishedAt: String,
    @SerializedName("highlight") val highlight: String,
    @SerializedName("url") val url: String,
    @SerializedName("image_url") val imageUrl: String
)