package com.roger.test.ui.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.chad.library.adapter4.BaseQuickAdapter
import com.chad.library.adapter4.viewholder.QuickViewHolder
import com.roger.test.R
import com.roger.test.ui.bean.MainNavigationBean

class MainPageAdapter : BaseQuickAdapter<MainNavigationBean, QuickViewHolder>() {

    override fun onBindViewHolder(
        holder: QuickViewHolder,
        position: Int,
        item: MainNavigationBean?
    ) {

        val itemText = holder.getView<TextView>(R.id.item_text)
        itemText.text = item?.name
    }

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): QuickViewHolder {
        return QuickViewHolder(R.layout.adapter_main_navigation, parent)
    }

}