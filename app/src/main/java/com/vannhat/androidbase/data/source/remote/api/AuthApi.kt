package com.vannhat.androidbase.data.source.remote.api

import com.vannhat.androidbase.data.model.PostData
import com.vannhat.androidbase.data.source.remote.api.response.DataResponse
import retrofit2.http.GET

interface AuthApi {
    @GET("5926c34212000035026871cd")
    suspend fun getPosts(): DataResponse<List<PostData>>

    @GET("5926ce9d11000096006ccb30")
    suspend fun getBlogPosts(): DataResponse<List<PostData>>
}
