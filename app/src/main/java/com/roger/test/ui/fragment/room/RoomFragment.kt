package com.roger.test.ui.fragment.room

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter4.BaseQuickAdapter
import com.roger.test.R
import com.roger.test.databinding.FragmentRoomBinding
import com.roger.test.ui.adapter.RoomPageAdapter
import com.roger.test.ui.base.BaseFragment
import com.roger.test.util.room.PersonInfoBean
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RoomFragment : BaseFragment<RoomViewModel, FragmentRoomBinding>(R.layout.fragment_room) {


    override val viewModel: RoomViewModel by viewModels()


    private lateinit var mAdapter: RoomPageAdapter

    override fun onViewCreated(savedInstanceState: Bundle?) {

        initView()

        initEvents()
    }

    private fun initView() {

        viewDataBinding.textAdd.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val personInfoBean = PersonInfoBean(0 , viewDataBinding.editName.text.toString(),
                    viewDataBinding.editAge.text.toString())
                viewModel.insertPerson(personInfoBean)

                ToastUtils.getDefaultMaker().setGravity(Gravity.CENTER, 0,0).show("添加成功")

                withContext(Dispatchers.Main) {
                    viewDataBinding.editName.setText("")
                    viewDataBinding.editAge.setText("")
                }
            }
        }


        viewDataBinding.query.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val query1 = viewModel.query()

                withContext(Dispatchers.Main) {
                    mAdapter.submitList(query1)
                }


            }
        }

        viewDataBinding.tvDelete.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                val query1 = viewModel.deleteAll()

                ToastUtils.showShort("删除成功")

            }
        }

        mAdapter = RoomPageAdapter()
        viewDataBinding.rvResult.adapter = mAdapter

        mAdapter.setOnItemClickListener(object:BaseQuickAdapter.OnItemClickListener<PersonInfoBean> {
            override fun onClick(
                adapter: BaseQuickAdapter<PersonInfoBean, *>,
                view: View,
                position: Int
            ) {

                val item = adapter.getItem(position)
                ToastUtils.showShort("" + item?.uid + "-----------${item?.name}"+ "-----------${item?.age}")
            }

        })


    }

    private fun initEvents() {


    }
}