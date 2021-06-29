package com.vannhat.androidbase.data.source.remote.repository

import com.vannhat.androidbase.data.model.PostData
import com.vannhat.androidbase.data.source.remote.PostRemoteDataSource
import com.vannhat.androidbase.domain.repository.PostRepository

class PostRepositoryImpl(private val postRemoteDataSource: PostRemoteDataSource) : PostRepository {

    override suspend fun getPosts(): List<PostData> {
        return postRemoteDataSource.getPosts()
    }

    override suspend fun getBlogPosts(): List<PostData> {
        return postRemoteDataSource.getBlogPosts()
    }

}
