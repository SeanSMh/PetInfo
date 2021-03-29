package com.sean.petinfo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sean.petinfo.api.NetApi
import com.sean.petinfo.api.PetListInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerPet: RecyclerView
    private lateinit var petAdapter: PetListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        loadData()
    }

    private fun initRecyclerView() {
        recyclerPet = findViewById(R.id.recycler_pet)
        petAdapter = PetListAdapter()
        recyclerPet.run {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = petAdapter
        }
    }

    private fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                NetApi.getPetList(::loadSuccess, ::loadError, ::loadFailure)
            }
        }
    }

    /**
     * 处理数据
     */
    private fun loadSuccess(petListInfo: PetListInfo) {
        Log.e("Sean--->", petListInfo.result?.petFamilyListInfo.toString())
        petListInfo.result?.petFamilyListInfo?.let {
            petAdapter.addData(it)
        }
    }

    private fun loadError() {

    }

    private fun loadFailure(t: Throwable) {
        Log.e("Sean--->", "错误原因$t")
    }
}