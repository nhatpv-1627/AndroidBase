package com.vannhat.androidbase.data.source.remote.api.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RefreshTokenRequest(
    @Expose
    @SerializedName("refresh_token")
    val refreshToken: String
)
