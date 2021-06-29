package com.vannhat.androidbase.data.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @Expose
    @SerializedName("status")
    val status: String?,

    @Expose
    @SerializedName("code")
    val errorCode: Int?,

    @Expose
    @SerializedName("message")
    val message: String?
)
