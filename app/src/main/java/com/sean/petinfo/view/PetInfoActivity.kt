package com.sean.petinfo.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sean.petinfo.R
import com.sean.petinfo.api.PetInfoResult
import com.sean.petinfo.databinding.ActivityPetInfoBinding
import com.sean.petinfo.viewmodel.PetListViewModel
import com.sean.petinfo.viewmodel.PetViewModelFactory

/**
 * Author: Sean-Shen
 * Date: 2021/3/4
 * Desc: 宠物详情页
 */
class PetInfoActivity : AppCompatActivity(), DataBindingOnclickHandler {

    private lateinit var toolBar: Toolbar
    private var petId: String? = null

    private lateinit var petViewModel: PetListViewModel
    private lateinit var dataBinding: ActivityPetInfoBinding

    companion object {
        private const val PET_NAME = "pet_name"
        private const val PET_ID = "pet_id"
        fun startActivity(context: Context, petName: String, petID: String) {
            val intent = Intent(context, PetInfoActivity::class.java)
            intent.putExtra(PET_NAME, petName)
            intent.putExtra(PET_ID, petID)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initArgs()
        initVieModel()
        loadFromServer()
    }

    private fun initView() {
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_pet_info)
        toolBar = findViewById(R.id.tool_bar)
    }

    private fun initArgs() {
        val petName = intent.getStringExtra(PET_NAME)
        petId = intent.getStringExtra(PET_ID)
        toolBar.findViewById<TextView>(R.id.tv_toolBar_title)?.text = petName
    }

    private fun initVieModel() {
        petViewModel = ViewModelProvider(
            this@PetInfoActivity,
            PetViewModelFactory(this)
        ).get(PetListViewModel::class.java)
    }

    private fun loadFromServer() {
        petId?.let {
            petViewModel.loadPetInfoFromServer(
                it,
                ::loadSuccess,
                ::loadError,
                ::loadFailure
            )
        }
    }

    private fun loadSuccess(entity: PetInfoResult) {
        dataBinding.petInfo = entity
        dataBinding.clickHandler = this
    }

    private fun loadError(errorCode: Int) {
        Log.e("Sean--->", "网络访问出错$errorCode")
    }

    private fun loadFailure(t: Throwable) {
        Log.e("Sean--->", "网络访问失败${t.toString()}")
    }

    override fun onImgClick(view: View) {
        startActivity(Intent(this, CatListActivity::class.java))
    }
}