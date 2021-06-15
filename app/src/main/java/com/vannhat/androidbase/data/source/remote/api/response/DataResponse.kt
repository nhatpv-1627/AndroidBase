package com.vannhat.androidbase.data.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataResponse<T>(
    @Expose @SerializedName("data") val data: T,
    @Expose @SerializedName("meta") val meta: Meta? = null
) {
    data class Meta(
        @Expose
        @SerializedName("current_page")
        val currentPage: Int?,
        @Expose
        @SerializedName("next_page")
        val nextPage: Int?,
        @Expose
        @SerializedName("prev_page")
        val prevPage: Int?,
        @Expose
        @SerializedName("total_pages")
        val totalPages: Int?
    )
}
