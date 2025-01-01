package com.roger.test.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.roger.common.base.BaseViewModel

abstract class BaseActivity<VM : BaseViewModel, VD : ViewDataBinding> : AppCompatActivity() {

    protected abstract val viewDataBinding: VD
    protected abstract val viewModel: VM

}