package com.vannhat.androidbase.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vannhat.androidbase.BuildConfig
import com.vannhat.androidbase.data.source.local.api.SharedPrefApi
import com.vannhat.androidbase.data.source.remote.api.AuthApi
import com.vannhat.androidbase.data.source.remote.api.NoneAuthApi
import com.vannhat.androidbase.data.source.remote.api.middleware.AuthInterceptor
import com.vannhat.androidbase.data.source.remote.api.middleware.BasicAuthInterceptor
import com.vannhat.androidbase.data.source.remote.api.middleware.ServiceGenerator
import com.vannhat.androidbase.data.source.remote.api.middleware.TokenAuthenticator
import com.vannhat.androidbase.utils.config.ApiConfig
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module

fun buildGson(): Gson {
    return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
}

private fun buildHttpLog(): HttpLoggingInterceptor {
    val logLevel =
        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    return HttpLoggingInterceptor().setLevel(logLevel)
}

private fun buildAuthInterceptor(sharedPrefApi: SharedPrefApi): AuthInterceptor {
    return AuthInterceptor(sharedPrefApi)
}

private fun buildBasicAuthInterceptor(): BasicAuthInterceptor {
    return BasicAuthInterceptor()
}

private fun buildTokenAuthenticator(
    api: NoneAuthApi,
    sharedPrefApi: SharedPrefApi
): TokenAuthenticator {
    return TokenAuthenticator(api, sharedPrefApi)
}

private fun buildNoneAuthApi(gson: Gson): NoneAuthApi {
    return ServiceGenerator.generate(
        ApiConfig.baseUrl(),
        NoneAuthApi::class.java,
        gson, null,
        buildHttpLog(), buildBasicAuthInterceptor()
    )
}

private fun buildAuthApi(
    gson: Gson,
    sharedPrefApi: SharedPrefApi,
    noneAuthApi: NoneAuthApi
): AuthApi {
    return ServiceGenerator.generate(
        ApiConfig.baseUrl(),
        AuthApi::class.java,
        gson,
        buildTokenAuthenticator(noneAuthApi, sharedPrefApi),
        buildHttpLog(), buildAuthInterceptor(sharedPrefApi), buildBasicAuthInterceptor()
    )
}

val networkModule = module {
    single { buildGson() }
    single { buildNoneAuthApi(get()) }
    single { buildAuthApi(get(), get(), get()) }
}
