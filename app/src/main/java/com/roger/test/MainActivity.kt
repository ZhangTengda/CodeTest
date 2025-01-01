package com.roger.test

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.ToastUtils
import com.chad.library.adapter4.BaseQuickAdapter
import com.chad.library.adapter4.BaseQuickAdapter.OnItemClickListener
import com.roger.test.databinding.ActivityMainBinding
import com.roger.test.ui.adapter.MainPageAdapter
import com.roger.test.ui.base.BaseActivity
import com.roger.test.ui.bean.MainNavigationBean
import com.roger.test.ui.show.ShowActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

//@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {


    override val viewModel: MainViewModel by viewModels()

    override val viewDataBinding: ActivityMainBinding by ActivityDataBindingDelegate(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mAdapter = MainPageAdapter()
        viewDataBinding.mainRecyclerview.adapter = mAdapter

//        mAdapter.setOnItemClickListener(object: OnItemClickListener<MainNavigationBean> {
//            override fun onClick(
//                adapter: BaseQuickAdapter<MainNavigationBean, *>,
//                view: View,
//                position: Int
//            ) {
//
//            }
//
//        })


        val mainItem1 = MainNavigationBean("请求", "Other")
        val mainItem2 = MainNavigationBean("Room数据库", "Other")
        val mainItem3 = MainNavigationBean("请求2", "Other")
        val mainItem4 = MainNavigationBean("请求3", "Other")
        val mainItem5 = MainNavigationBean("请求4", "Other")
        val mainItem6 = MainNavigationBean("请求5", "Other")
        val mainItem7 = MainNavigationBean("请求6", "Other")


        val mainList = ArrayList<MainNavigationBean>()
        mainList.add(mainItem1)
        mainList.add(mainItem2)
        mainList.add(mainItem3)
        mainList.add(mainItem4)
        mainList.add(mainItem5)
        mainList.add(mainItem6)
        mainList.add(mainItem7)

        mAdapter.submitList(mainList)

        mAdapter.setOnItemClickListener { adapter, view, position ->

            ToastUtils.showShort(mAdapter.getItem(position)?.name)
            val intent = Intent(this, ShowActivity::class.java)
            intent.putExtra("count", position + 1)
            startActivity(intent)
        }
    }
}