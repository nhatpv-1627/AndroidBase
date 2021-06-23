package com.vannhat.androidbase.data.source.remote.api.middleware

import android.util.Log
import com.vannhat.androidbase.data.source.local.api.SharedPrefApi
import com.vannhat.androidbase.data.source.local.api.pref.SharedPrefKeys.ACCESS_TOKEN
import com.vannhat.androidbase.data.source.local.api.pref.SharedPrefKeys.REFRESH_TOKEN
import com.vannhat.androidbase.data.source.remote.api.NoneAuthApi
import com.vannhat.androidbase.data.source.remote.api.request.RefreshTokenRequest
import com.vannhat.androidbase.utils.config.ApiConfig.AUTHORIZATION
import com.vannhat.androidbase.utils.config.ApiConfig.BEARER
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import retrofit2.HttpException
import java.net.HttpURLConnection

class TokenAuthenticator(
    private val api: NoneAuthApi,
    private val sharedPrefApi: SharedPrefApi
) : Authenticator {

    /**
     * If we've refresh token failed [RETRY_COUNT_LIMIT] times, give up.
     */
    override fun authenticate(route: Route?, response: Response): Request? {
        Log.d(TAG, "Call refresh token")
        if (responseCount(response) >= RETRY_COUNT_LIMIT) {
            return null
        }
        return runBlocking {
            sharedPrefApi.get(REFRESH_TOKEN, String::class.java)?.let { token ->
                try {
                    val newToken = api.refreshToken(RefreshTokenRequest(token)).data
                    sharedPrefApi.put(ACCESS_TOKEN, newToken.accessToken)

                    response.request.newBuilder()
                        .header(
                            AUTHORIZATION,
                            "$BEARER ${newToken.accessToken}"
                        ).build()
                } catch (error: Exception) {
                    throw RefreshTokenFailException()
                }
            }
        }
    }

    private fun responseCount(response: Response): Int {
        var responseMutable = response.priorResponse
        var count = 1
        while (responseMutable != null) {
            count++
            responseMutable = response.priorResponse
        }
        return count
    }

    companion object {
        private const val TAG = "TokenAuthenticator"
        private const val RETRY_COUNT_LIMIT = 3
    }
}
