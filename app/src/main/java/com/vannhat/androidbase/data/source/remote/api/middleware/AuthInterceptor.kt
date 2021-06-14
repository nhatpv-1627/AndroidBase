package com.vannhat.androidbase.data.source.remote.api.middleware

import com.vannhat.androidbase.data.source.local.api.SharedPrefApi
import com.vannhat.androidbase.data.source.local.api.pref.SharedPrefKeys
import com.vannhat.androidbase.utils.config.ApiConfig.AUTHORIZATION
import com.vannhat.androidbase.utils.config.ApiConfig.BEARER
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(private val sharedPrefApi: SharedPrefApi) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val newRequestBuilder = originalRequest.newBuilder()
        val accessToken =
            sharedPrefApi.get(SharedPrefKeys.ACCESS_TOKEN, String::class.java)
        accessToken?.let {
            newRequestBuilder.addHeader(
                AUTHORIZATION, "$BEARER $it"
            )
        }
        return chain.proceed(newRequestBuilder.build())
    }
}
