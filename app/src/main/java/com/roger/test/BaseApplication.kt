package com.roger.test

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.roger.common.base.app.ApplicationProxy
import com.roger.common.base.app.CommonApplicationProxy
import com.roger.common.base.http.RetrofitManager
import com.roger.common.base.http.cookie.CookieCacheHelper
import com.roger.common.base.http.cookie.UserCookieJarImpl
import com.roger.test.util.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp


//@HiltAndroidApp
class BaseApplication : Application() {

    lateinit var db :  AppDatabase

    companion object {
        lateinit var appContext: Context
    }

    private val proxies = listOf<ApplicationProxy>(CommonApplicationProxy)

    override fun onCreate() {
        super.onCreate()

        appContext = applicationContext

        proxies.forEach { it.onCreate(this) }

        RetrofitManager.init()
    }

    override fun onTerminate() {
        super.onTerminate()
        proxies.forEach { it.onTerminate() }
    }
}