package com.sean.petinfo.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sean.petinfo.R
import com.sean.petinfo.api.NetApi
import com.sean.petinfo.api.PetListInfo
import com.sean.petinfo.viewmodel.PetListViewModel
import com.sean.petinfo.viewmodel.PetViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerPet: RecyclerView
    private lateinit var petAdapter: PetListAdapter
    private lateinit var petViewModel: PetListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initViewModel()
        loadData()
        //petViewModel.deleteAllData()
    }

    private fun initRecyclerView() {
        recyclerPet = findViewById(R.id.recycler_pet)
        petAdapter = PetListAdapter()
        recyclerPet.run {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = petAdapter
        }

        petAdapter.setOnItemClickListener { adapter, view, position ->
            Toast.makeText(this, "点击子项", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initViewModel() {
        petViewModel =
            ViewModelProvider(this, PetViewModelFactory(this)).get(PetListViewModel::class.java)
        petViewModel.run {
            petList.observe(this@MainActivity) {
                petAdapter.addData(it)
            }
        }
    }

    private fun loadData() {
        /*CoroutineScope(Dispatchers.Main).launch {  //此时，好像需要在onCreate()方法中取消协程
            NetApi.getPetList(::loadSuccess, ::loadError, ::loadFailure)
        }*/

        petViewModel.loadDataFromServer(::loadSuccess, ::loadError, ::loadFailure)
    }

    /**
     * 处理数据
     */
    private fun loadSuccess(petListInfo: PetListInfo) {
        Log.e("Sean--->", petListInfo.result?.petFamilyListInfo.toString())
        petListInfo.result?.petFamilyListInfo?.let {
            petViewModel.updatePetList(it)
        }
    }

    private fun loadError(errorCode: Int) {
        Log.e("Sean--->", "errorCode: $errorCode")
    }

    private fun loadFailure(t: Throwable) {
        Log.e("Sean--->", "错误原因$t")
    }
}