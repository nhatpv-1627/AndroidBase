package com.vannhat.androidbase.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostData(
    @Expose
    @SerializedName("title")
    val title: String?,

    @Expose
    @SerializedName("description")
    val description: String?,

    @Expose
    @SerializedName("author")
    val author: String?,

    @Expose
    @SerializedName("img_url")
    val imgUrl: String?,

    @Expose
    @SerializedName("project_url")
    val projectUrl: String?,
) : BaseData()
