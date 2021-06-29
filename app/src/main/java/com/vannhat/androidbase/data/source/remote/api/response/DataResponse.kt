package com.vannhat.androidbase.data.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataResponse<T>(
    @Expose @SerializedName("data") val data: T,
    @Expose @SerializedName("status_code") val statusCode: String?,
    @Expose @SerializedName("message") val message: String?
)
