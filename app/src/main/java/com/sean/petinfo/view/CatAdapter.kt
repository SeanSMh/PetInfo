package com.sean.petinfo.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sean.petinfo.R
import com.sean.petinfo.databinding.ItemCatBinding

/**
 * Author: Sean-Shen
 * Date: 2021/4/8
 * Desc: adapter of CatListActivity
 */
class CatAdapter : BaseQuickAdapter<CatInfoEntity, CatAdapter.MyHolder>(R.layout.item_cat) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val dBing = DataBindingUtil.inflate<ItemCatBinding>(
            LayoutInflater.from(parent.context),
            this.mLayoutResId,
            null,
            false
        )
        return MyHolder(dBing.root)
    }

    override fun convert(helper: MyHolder?, item: CatInfoEntity?) {
        val dataBiding = helper?.itemView?.let { DataBindingUtil.getBinding<ItemCatBinding>(it) }
        dataBiding?.catInfo = item
    }

    inner class MyHolder(myView: View) : BaseViewHolder(myView)
}