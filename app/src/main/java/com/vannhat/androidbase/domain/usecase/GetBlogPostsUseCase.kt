package com.vannhat.androidbase.domain.usecase

import com.vannhat.androidbase.domain.entities.BlogModel
import com.vannhat.androidbase.domain.mapper.BlogMapper
import com.vannhat.androidbase.domain.repository.PostRepository
import com.vannhat.androidbase.domain.usecase.base.BaseDirectUseCase
import com.vannhat.androidbase.domain.usecase.base.NoneInput
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetBlogPostsUseCase(
    private val postRepository: PostRepository,
    private val blogMapper: BlogMapper
) : BaseDirectUseCase<NoneInput, Flow<List<BlogModel>>>() {
    override suspend fun CoroutineScope.buildUseCase(input: NoneInput): Flow<List<BlogModel>> {
        return flowOf(postRepository.getBlogPosts().map { blogMapper.map(it) })
    }

}
