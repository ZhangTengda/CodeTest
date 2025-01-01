package com.roger.common.base.app

import android.app.Application

interface ApplicationProxy {

    fun onCreate(application: Application)

    fun onTerminate()

}