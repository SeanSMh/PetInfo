package com.sean.petinfo

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.sean.petinfo.api.PetFamilyListInfo

/**
 * Author: Sean-Shen
 * Date: 2021/3/26
 * Desc:
 */
class PetListAdapter : BaseQuickAdapter<PetFamilyListInfo, BaseViewHolder>(R.layout.item_pet) {

    override fun convert(helper: BaseViewHolder?, item: PetFamilyListInfo?) {
        val imgPet = helper?.getView<ImageView>(R.id.img_pet)
        imgPet?.let {
            Glide.with(it.context).load(item?.coverUrl)
                .transform(CenterCrop(), CircleImageViewTransformation(12f)).into(imgPet)
        }
    }
}