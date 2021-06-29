package com.vannhat.androidbase.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vannhat.androidbase.BuildConfig
import com.vannhat.androidbase.data.source.local.api.SharedPrefApi
import com.vannhat.androidbase.data.source.remote.api.AuthApi
import com.vannhat.androidbase.data.source.remote.api.NoneAuthApi
import com.vannhat.androidbase.data.source.remote.api.middleware.*
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

private fun buildConnectivityInterceptor(context: Context) = ConnectivityInterceptor(context)

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

private fun buildNoneAuthApi(gson: Gson, context: Context): NoneAuthApi {
    return ServiceGenerator.generate(
        ApiConfig.baseUrl(),
        NoneAuthApi::class.java,
        gson, null,
        buildHttpLog(), buildBasicAuthInterceptor(),
        buildConnectivityInterceptor(context)
    )
}

private fun buildAuthApi(
    gson: Gson,
    sharedPrefApi: SharedPrefApi,
    noneAuthApi: NoneAuthApi,
    context: Context
): AuthApi {
    return ServiceGenerator.generate(
        ApiConfig.baseUrl(),
        AuthApi::class.java,
        gson,
        buildTokenAuthenticator(noneAuthApi, sharedPrefApi),
        buildHttpLog(),
        buildAuthInterceptor(sharedPrefApi),
        buildBasicAuthInterceptor(),
        buildConnectivityInterceptor(context)
    )
}

val networkModule = module {
    single { buildGson() }
    single { buildNoneAuthApi(get(), get()) }
    single { buildAuthApi(get(), get(), get(), get()) }
}
