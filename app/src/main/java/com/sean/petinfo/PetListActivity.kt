package com.sean.petinfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Author: Sean-Shen
 * Date: 2021/3/4
 * Desc: 宠物列表页
 */
class PetListActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_list)
        initView()
    }

    private fun initView() {
    }

    private fun loadFromServer() {

    }
}