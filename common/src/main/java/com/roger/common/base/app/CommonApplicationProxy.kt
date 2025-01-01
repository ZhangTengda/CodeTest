package com.roger.common.base.app

import android.app.Application
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

object CommonApplicationProxy : ApplicationProxy, ViewModelStoreOwner {

        lateinit var application: Application
//
//    private val viewModelStoreNew = ViewModelStore()
//
//    override fun onCreate(application: Application) {
//        this.application = application
//    }
//
//    override fun onTerminate() {
//        viewModelStoreNew.clear()
//    }
//
//    override fun getViewModelStore() = viewModelStoreNew
    override fun onCreate(application: Application) {
        this.application = application
    }

    override fun onTerminate() {
        viewModelStore.clear()
    }

    override val viewModelStore: ViewModelStore
        get() = ViewModelStore()
}