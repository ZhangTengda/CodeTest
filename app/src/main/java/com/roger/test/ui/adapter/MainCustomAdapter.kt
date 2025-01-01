package com.roger.test.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.chad.library.adapter4.BaseQuickAdapter
import com.chad.library.adapter4.viewholder.QuickViewHolder
import com.roger.test.R
import com.roger.test.databinding.AdapterMainNavigationBinding
import com.roger.test.ui.bean.MainNavigationBean

class MainCustomAdapter : BaseQuickAdapter<MainNavigationBean, MainCustomAdapter.VH>() {

    class VH(
        parent: ViewGroup,
        val binding: AdapterMainNavigationBinding = AdapterMainNavigationBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ),
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: VH, position: Int, item: MainNavigationBean?) {

    }

    override fun onCreateViewHolder(context: Context, parent: ViewGroup, viewType: Int): VH {
        return VH(parent)
    }

//    override fun onBindViewHolder(
//        holder: QuickViewHolder,
//        position: Int,
//        item: MainNavigationBean?
//    ) {
//
//    }
//
//  MainNavigationBean  override fun onCreateViewHolder(
//        context: Context,
//        parent: ViewGroup,
//        viewType: Int
//    ): QuickViewHolder {
//        return QuickViewHolder(R.layout.adapter_main_navigation, parent)
//    }

}