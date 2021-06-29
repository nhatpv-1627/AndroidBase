package com.vannhat.androidbase.di

import com.vannhat.androidbase.domain.usecase.GetBlogPostsUseCase
import com.vannhat.androidbase.domain.usecase.GetFlowPostsUseCase
import com.vannhat.androidbase.domain.usecase.GetPostsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetPostsUseCase(get(), get()) }
    factory { GetBlogPostsUseCase(get(), get()) }
    factory { GetFlowPostsUseCase(get(), get()) }
}
