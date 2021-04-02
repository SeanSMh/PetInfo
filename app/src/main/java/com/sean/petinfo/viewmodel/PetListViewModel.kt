package com.sean.petinfo.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sean.petinfo.api.NetApi
import com.sean.petinfo.api.PetFamilyListInfo
import com.sean.petinfo.api.PetListInfo
import com.sean.petinfo.database.PetDao
import com.sean.petinfo.database.PetDb
import com.sean.petinfo.database.PetInfoEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Author: Sean-Shen
 * Date: 2021/3/30
 * Desc:
 */
class PetListViewModel(context: Context) : ViewModel() {

    private var myDbDao: PetDao? = null

    val petList: LiveData<MutableList<PetInfoEntity>>
        get() = _petList
    private var _petList = MutableLiveData<MutableList<PetInfoEntity>>()

    init {
        myDbDao = PetDb.getInstance(context)?.PetDao()
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                myDbDao?.getAllData()?.also { _petList.postValue(it) }
            }
        }
    }

    fun loadDataFromServer(loadSuccess: (PetListInfo) -> Unit,
                           loadError: (Int) -> Unit,
                           loadFailure: (Throwable) -> Unit) {
        viewModelScope.launch {        //可以自动取消协程
            NetApi.getPetList(loadSuccess, loadError, loadFailure)
        }
    }

    fun updatePetList(petList: MutableList<PetFamilyListInfo>) {
        val newPetList = mutableListOf<PetInfoEntity>()
        petList.forEach {
            val petInfoEntity = PetInfoEntity()
            it.name?.let { na ->
                petInfoEntity.petName = na
            }
            it.engName?.let { eg ->
                petInfoEntity.petEngName = eg
            }
            it.petId?.let { id ->
                petInfoEntity.petId = id
            }
            it.coverUrl?.let { ur ->
                petInfoEntity.petAvatar = ur
            }
            it.price?.let { pr ->
                petInfoEntity.petPrice = pr
            }
            newPetList.add(petInfoEntity)
        }
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                myDbDao?.saveToDb(newPetList)
            }
        }
        _petList.postValue(newPetList)
    }

    fun deleteAllData() {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                myDbDao?.deleteAll()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}