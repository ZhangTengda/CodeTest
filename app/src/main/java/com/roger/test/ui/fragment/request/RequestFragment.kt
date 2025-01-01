package com.roger.test.ui.fragment.request

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.roger.test.R
import com.roger.test.databinding.FragmentRequestBinding
import com.roger.test.ui.base.BaseFragment
import kotlinx.coroutines.launch

class RequestFragment : BaseFragment<RequestViewModel, FragmentRequestBinding>(R.layout.fragment_request) {

    private val homeViewModel by viewModels<RequestViewModel>(this::requireParentFragment)

    override val viewModel: RequestViewModel by viewModels()

    override fun onViewCreated(savedInstanceState: Bundle?) {

        viewDataBinding.text.setOnClickListener {
            lifecycleScope.launch {
                viewModel.getBanners()
            }
        }

        initEvents()
    }

    private fun initEvents() {

        viewModel.apply {
            refreshLiveData.observe(viewLifecycleOwner) {
                viewDataBinding.result.text = it.toString()
            }
        }
    }
}