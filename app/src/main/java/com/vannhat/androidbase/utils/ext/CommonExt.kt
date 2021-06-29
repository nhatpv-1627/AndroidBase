package com.vannhat.androidbase.utils.ext

import com.google.gson.Gson

inline fun <reified T> parseDataFromJson(gson: Gson, json: String?): T {
    return gson.fromJson(json, T::class.java) ?: throw IllegalStateException("Fail to parse json")
}
