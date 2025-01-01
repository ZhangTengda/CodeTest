package com.roger.test.ui.adapter

import android.content.Context
import android.view.ViewGroup
import android.widget.TextView
import com.chad.library.adapter4.BaseQuickAdapter
import com.chad.library.adapter4.viewholder.QuickViewHolder
import com.roger.test.R
import com.roger.test.util.room.PersonInfoBean

class RoomPageAdapter : BaseQuickAdapter<PersonInfoBean, QuickViewHolder>() {

    override fun onBindViewHolder(
        holder: QuickViewHolder,
        position: Int,
        item: PersonInfoBean?
    ) {
        val nameText = holder.getView<TextView>(R.id.item_name)
        val ageText = holder.getView<TextView>(R.id.item_age)
        nameText.text = item?.name
        ageText.text = item?.age
    }

    override fun onCreateViewHolder(
        context: Context,
        parent: ViewGroup,
        viewType: Int
    ): QuickViewHolder {
        return QuickViewHolder(R.layout.adapter_room_item, parent)
    }

}