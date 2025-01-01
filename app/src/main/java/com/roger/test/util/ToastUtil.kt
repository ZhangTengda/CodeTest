package com.roger.test.util

import android.view.Gravity
import com.blankj.utilcode.util.ToastUtils

object ToastUtil {

    fun toastCenter(str: String?) {
        str?.let {
            ToastUtils.getDefaultMaker().setGravity(Gravity.CENTER, 0, 0).show(str)
        }
    }
}