package com.roger.test.ui.fragment.request

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roger.common.base.BaseViewModel
import com.roger.common.base.http.RetrofitManager
import com.roger.common.base.http.adapter.whenSuccess
import com.roger.common.services.HomeService
import com.roger.common.services.model.Banner
import com.roger.test.ui.home.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


//@HiltViewModel
class RequestViewModel : BaseViewModel() {

    private val _refreshLiveData = MutableLiveData<List<Banner>>()
    val refreshLiveData: LiveData<List<Banner>> = _refreshLiveData

     fun getBanners(){

         viewModelScope.launch {

             val banner = RetrofitManager.getService(HomeService::class.java)
                 .getBanner()

             banner.whenSuccess {
                 Log.d("rogerzhang", "===================="+it.toString())


                 _refreshLiveData.postValue(it)
             }
         }

    }
}