package com.vannhat.androidbase.data.source.remote

import com.vannhat.androidbase.data.model.PostData
import com.vannhat.androidbase.data.source.remote.api.AuthApi

class PostRemoteDataSource(private val authApi: AuthApi) : RemoteDataSource() {

    suspend fun getPosts(): List<PostData> {
        return authApi.getPosts().data
    }

    suspend fun getBlogPosts(): List<PostData> {
        return authApi.getBlogPosts().data
    }

}
