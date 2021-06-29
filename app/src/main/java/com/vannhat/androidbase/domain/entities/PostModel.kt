package com.vannhat.androidbase.domain.entities

data class PostModel(
    val title: String?,
    val description: String?,
    val author: String?,
    val imgUrl: String?,
    val projectUrl: String?,
) : BaseModel()
