package com.vannhat.androidbase.di

import com.vannhat.androidbase.domain.mapper.BlogMapper
import com.vannhat.androidbase.domain.mapper.PostMapper
import org.koin.dsl.module

val mapperModule = module {
    factory { PostMapper() }
    factory { BlogMapper() }
}
