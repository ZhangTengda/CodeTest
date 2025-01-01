package com.roger.common.base.http.interceptor


import com.roger.common.base.AppLog
import okhttp3.logging.HttpLoggingInterceptor

val logInterceptor by lazy {
    HttpLoggingInterceptor { AppLog.d(msg = it) }.setLevel(if (true) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.BASIC)
}