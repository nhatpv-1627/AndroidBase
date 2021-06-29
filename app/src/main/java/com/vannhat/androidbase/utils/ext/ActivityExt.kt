package com.vannhat.androidbase.utils.ext

import com.google.android.material.snackbar.Snackbar
import com.vannhat.androidbase.R
import com.vannhat.androidbase.data.source.remote.api.middleware.NoConnectivityException
import com.vannhat.androidbase.data.source.remote.api.middleware.RefreshTokenFailException
import com.vannhat.androidbase.data.source.remote.api.response.ErrorResponse
import com.vannhat.androidbase.ui.base.BaseActivity
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

fun BaseActivity<*>.showErrorMessage(message: String) {
    Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
}

fun BaseActivity<*>.handleError(
    error: Exception,
    onServerError: ((Pair<Int, String>) -> Boolean)? = null
) {
    when (error) {
        is HttpException -> {
            val serverErr = parseServerError(error)
            if (onServerError == null || !onServerError.invoke(serverErr))
                showErrorMessage(serverErr.second)
        }
        is SocketTimeoutException -> {
            showErrorMessage(getString(R.string.error_timeout))
        }
        is NoConnectivityException -> {
            showErrorMessage(getString(R.string.no_connection))
        }
        is RefreshTokenFailException -> {
            // TODO handle when refresh token fail
        }
        is IOException -> {
            showErrorMessage(getString(R.string.unexpected_error))
        }
        else -> {
            showErrorMessage(getString(R.string.unexpected_error))
        }
    }
}

private fun BaseActivity<*>.parseServerError(
    e: HttpException
): Pair<Int, String> {
    val responseBody = e.response()?.errorBody()
    val responseCode = e.response()?.code()
    val unknownError = getString(R.string.unexpected_error)
    return responseBody?.let {
        try {
            val error =
                parseDataFromJson<ErrorResponse>(gson, responseBody.string())
            Pair(responseCode ?: UNKNOWN_ERROR_CODE, error.message ?: unknownError)
        } catch (ex: Exception) {
            Pair(UNKNOWN_ERROR_CODE, e.message ?: unknownError)
        }
    } ?: kotlin.run {
        Pair(UNKNOWN_ERROR_CODE, unknownError)
    }

}

private const val UNKNOWN_ERROR_CODE = -1
