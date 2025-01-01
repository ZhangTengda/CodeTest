package com.roger.test.ui.show

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.roger.test.ActivityDataBindingDelegate
import com.roger.test.R
import com.roger.test.databinding.ActivityShowBinding
import com.roger.test.ui.base.BaseActivity
import com.roger.test.ui.base.BaseFragment
import com.roger.test.ui.fragment.request.RequestFragment
import com.roger.test.ui.fragment.room.RoomFragment

class ShowActivity: BaseActivity<ShowViewModel, ActivityShowBinding>(), BaseFragment.OnBackPressedListener {


    override val viewModel: ShowViewModel by viewModels()

    override val viewDataBinding: ActivityShowBinding by ActivityDataBindingDelegate(R.layout.activity_show)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val intExtra = intent?.getIntExtra("count", 1)
        initData(intExtra?:1)

    }

    private fun initData(i: Int) {
        when(i){
            1 -> {
                showFragment(RequestFragment())
            }
            2 -> {
                showFragment(RoomFragment())
            }

            3 -> {

            }

            4 -> {

            }

            5-> {

            }
            6 -> {

            }
        }
    }


    private fun showFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(viewDataBinding.fragmentShow.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }



}