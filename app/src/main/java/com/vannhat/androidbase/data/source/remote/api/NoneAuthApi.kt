package com.vannhat.androidbase.data.source.remote.api

import com.vannhat.androidbase.data.model.TokenData
import com.vannhat.androidbase.data.source.remote.api.request.RefreshTokenRequest
import com.vannhat.androidbase.data.source.remote.api.response.DataResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface NoneAuthApi {
    @POST("refresh_token")
    suspend fun refreshToken(@Body request: RefreshTokenRequest): DataResponse<TokenData>
}
