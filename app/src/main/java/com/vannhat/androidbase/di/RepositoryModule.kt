package com.vannhat.androidbase.di

import com.vannhat.androidbase.data.source.local.api.SharedPrefApi
import com.vannhat.androidbase.data.source.local.api.pref.SharedPrefApiImpl
import com.vannhat.androidbase.data.source.remote.PostRemoteDataSource
import com.vannhat.androidbase.data.source.remote.repository.PostRepositoryImpl
import com.vannhat.androidbase.domain.repository.PostRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<SharedPrefApi> { SharedPrefApiImpl(get(), get()) }
    single { PostRemoteDataSource(get()) }
    single<PostRepository> { PostRepositoryImpl(get()) }
}
