package com.vannhat.androidbase.domain.usecase

import com.vannhat.androidbase.domain.entities.PostModel
import com.vannhat.androidbase.domain.mapper.PostMapper
import com.vannhat.androidbase.domain.repository.PostRepository
import com.vannhat.androidbase.domain.usecase.base.BaseDirectUseCase
import com.vannhat.androidbase.domain.usecase.base.NoneInput
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetFlowPostsUseCase(
    private val postRepository: PostRepository,
    private val postMapper: PostMapper
) : BaseDirectUseCase<NoneInput, Flow<List<PostModel>>>() {
    override suspend fun CoroutineScope.buildUseCase(input: NoneInput): Flow<List<PostModel>> {
        return flowOf(postRepository.getPosts().map { postMapper.map(it) })
    }
}
