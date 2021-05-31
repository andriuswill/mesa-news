package com.andriuswill.mesa_news.data

import com.google.gson.annotations.SerializedName

data class HighLightsResponse(
    @SerializedName("data") val data: ArrayList<News>
)