package com.mem.mmhealthcare.data.vos

import com.google.gson.annotations.SerializedName

class HealthCareInfoVO {

    @SerializedName("id")
    val healthCareId: Int = 0

    @SerializedName("title")
    val title: String = ""

    @SerializedName("image")
    val image: String = ""

    @SerializedName("author")
    val author: AuthorVO?= null

    @SerializedName("short-description")
    val shortDescription: String = ""

    @SerializedName("published-date")
    val publishedDate: String = ""

    @SerializedName("complete-url")
    val completeUrl: String = ""

    @SerializedName("info-type")
    val infoIype: String? = null
}