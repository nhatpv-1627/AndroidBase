package com.vannhat.androidbase.domain.repository

import com.vannhat.androidbase.data.model.PostData

interface PostRepository {
    suspend fun getPosts(): List<PostData>

    suspend fun getBlogPosts(): List<PostData>
}
