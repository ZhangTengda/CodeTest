package com.roger.test.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.roger.common.base.BaseViewModel
import com.roger.test.ui.fragment.room.RoomFragment

abstract class BaseFragment<VM : BaseViewModel, VD : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    Fragment() {

    protected lateinit var viewDataBinding: VD
    protected abstract val viewModel: VM


    private var backPressedListener: OnBackPressedListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = DataBindingUtil.inflate<VD>(inflater, layoutResId, container, false)
        .also {
            it.lifecycleOwner = viewLifecycleOwner
            viewDataBinding = it
        }
        .root

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewCreated(savedInstanceState)
    }

    protected abstract fun onViewCreated(savedInstanceState: Bundle?)


    interface OnBackPressedListener {
        fun onBackPressed()
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnBackPressedListener) {
            backPressedListener = context
        } else {
            throw RuntimeException("$context must implement OnBackPressedListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        backPressedListener = null
    }

}