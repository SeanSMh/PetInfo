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
class CatAdapter : BaseQuickAdapter<CatInfoEntity, BaseViewHolder>(R.layout.item_cat) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val dBing = DataBindingUtil.inflate<ItemCatBinding>(
            LayoutInflater.from(parent.context),
            this.mLayoutResId,
            parent,
            false
        )
        return BaseViewHolder(dBing.root)
    }

    override fun convert(helper: BaseViewHolder?, item: CatInfoEntity?) {
        val dataBiding = helper?.itemView?.let { DataBindingUtil.getBinding<ItemCatBinding>(it) }
        dataBiding?.catInfo = item
    }

}