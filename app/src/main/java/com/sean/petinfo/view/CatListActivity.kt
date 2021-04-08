package com.sean.petinfo.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sean.petinfo.R

/**
 * Author: Sean-Shen
 * Date: 2021/4/8
 * Desc: 小猫列表页面
 */
class CatListActivity : AppCompatActivity() {

    private lateinit var recyclerCat: RecyclerView
    private lateinit var catAdapter: CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_list)

        initView()
        initData()
    }

    private fun initView() {
        recyclerCat = findViewById(R.id.recycler_cat)
        catAdapter = CatAdapter()
        recyclerCat.layoutManager = LinearLayoutManager(this)
        recyclerCat.adapter = catAdapter
    }

    private fun initData() {
        val cats = mutableListOf<CatInfoEntity>()
        for (i in 0..5) {
            cats.add(CatInfoEntity("狸花猫", "狸花猫很淘气，狸花猫很淘气，狸花猫很淘气，狸花猫很淘气..."))
        }

        catAdapter.setNewData(cats)
    }
}