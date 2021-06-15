package com.vannhat.androidbase.data.source.remote.api.middleware

import com.vannhat.androidbase.BuildConfig
import com.vannhat.androidbase.utils.config.ApiConfig
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response

class BasicAuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequestBuilder = originalRequest.newBuilder()
//        if (BuildConfig.FLAVOR == ApiConfig.STG_NAME) {
//            newRequestBuilder.addHeader(
//                ApiConfig.AUTHORIZATION, Credentials.basic(
//                    ApiConfig.BASIC_AUTH_NAME,
//                    ApiConfig.BASIC_AUTH_PASSWORD
//                )
//            )
//        }
        return chain.proceed(newRequestBuilder.build())
    }
}
