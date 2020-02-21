package com.paymaya.sdk.android.common.internal.di

import com.paymaya.sdk.android.common.LogLevel
import com.paymaya.sdk.android.common.internal.Logger
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

internal object CommonModule {
    fun getJson(): Json =
        Json(JsonConfiguration.Stable)

    fun getHttpClient(logLevel: LogLevel): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(Logger.mapToOkHttpLogLevel(logLevel)))
            .build()

    fun getLogger(logLevel: LogLevel): Logger =
        Logger(logLevel)
}
