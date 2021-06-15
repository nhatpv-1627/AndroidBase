package com.vannhat.androidbase.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TokenData(
    @Expose
    @SerializedName("access_token")
    val accessToken:String,
    @Expose
    @SerializedName("refresh_token")
    val refreshToken:String,
)
