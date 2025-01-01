package com.roger.test.ui.fragment.room

import androidx.lifecycle.viewModelScope
import com.roger.common.base.BaseViewModel
import com.roger.test.util.room.PersonInfoBean
import com.roger.test.util.room.AppDataBaseManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RoomViewModel : BaseViewModel() {

//    private val _refreshLiveData = MutableLiveData<List<Banner>>()
//    val refreshLiveData: LiveData<List<Banner>> = _refreshLiveData

     fun insertPerson(personInfoBean: PersonInfoBean) {
         val instance = AppDataBaseManager.instance

         val personDao = instance.personDao()

         personDao.insertAll(personInfoBean)
     }

    fun query() : List<PersonInfoBean>{
        val instance = AppDataBaseManager.instance
        val personDao = instance.personDao()
        val all = personDao.getAll()
        return all
    }

    fun loadAllByName(name:String): List<PersonInfoBean> {
        val instance = AppDataBaseManager.instance
        val personDao = instance.personDao()
        return  personDao.loadAllByName(name)
    }


    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            val instance = AppDataBaseManager.instance
            val personDao = instance.personDao()
            personDao.deleteAll()
        }
    }
}