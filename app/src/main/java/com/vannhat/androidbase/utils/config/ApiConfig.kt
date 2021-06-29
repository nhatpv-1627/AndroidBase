package com.vannhat.androidbase.utils.config

import com.vannhat.androidbase.BuildConfig

object ApiConfig {
    private const val BASE_URL_DEV = "http://www.mocky.io/v2/"
    private const val BASE_URL_STG = "https://vannhat.stg.com/v1/"
    private const val BASE_URL_PROD = "https://vannhat.prod.com/v1/"

    const val AUTHORIZATION = "Authorization"
    const val BEARER = "Bearer"

    const val BASIC_AUTH_NAME = "username"
    const val BASIC_AUTH_PASSWORD = "password"

    private const val DEV_NAME = "develop"
    private const val STG_NAME = "staging"

    fun baseUrl(): String {
        return when (BuildConfig.FLAVOR) {
            DEV_NAME -> {
                BASE_URL_DEV
            }
            STG_NAME -> {
                BASE_URL_STG
            }
            else -> {
                BASE_URL_PROD
            }
        }
    }
}
