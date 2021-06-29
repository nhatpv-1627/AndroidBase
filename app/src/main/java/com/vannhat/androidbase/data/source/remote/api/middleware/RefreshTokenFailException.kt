package com.vannhat.androidbase.data.source.remote.api.middleware

import java.io.IOException

class RefreshTokenFailException : IOException("401 - Refresh token failed!")
