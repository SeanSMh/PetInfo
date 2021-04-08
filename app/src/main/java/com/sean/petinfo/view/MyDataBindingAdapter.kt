package com.sean.petinfo.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Author: Sean-Shen
 * Date: 2021/4/7
 * Desc:
 */
class MyDataBindingAdapter {
    companion object {
        @BindingAdapter("app:imgSrc")
        @JvmStatic
        fun imageSrc(img: ImageView, url: String?) {
            /*if (url.isNullOrBlank()) {
                Glide.with(img.context)
                    .load("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1380123557,1988376769&fm=26&gp=0.jpg")
                    .into(img)
            } else {
                Glide.with(img.context).load(url).into(img)
            }*/
            Glide.with(img.context)
                .load("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1380123557,1988376769&fm=26&gp=0.jpg")
                .into(img)
        }
    }
}