package com.sean.petinfo.api

import com.google.gson.annotations.SerializedName

/**
 * Author: Sean-Shen
 * Date: 2021/4/6
 * Desc: 宠物详情信息实体实体类
 */
data class SinglePetInfo(
    @SerializedName("statusCode")
    val statusCode: String? = null,
    @SerializedName("desc")
    val desc: String? = null,
    @SerializedName("result")
    val result: PetInfoResult? = null
)

data class PetInfoResult(
    @SerializedName("petID")
    val petId: String? = null,
    @SerializedName("name")
    val petName: String? = null,
    @SerializedName("engName")  //英文名称
    val petEngName: String? = null,
    @SerializedName("character")   //性格特征
    val character: String? = null,
    @SerializedName("nation")
    val nation: String? = null,   //祖籍
    @SerializedName("easyOfDisease")   //易患病
    val easyOfDisease: String? = null,
    @SerializedName("life")   //寿命
    val life: String? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("des")
    val des: String? = null,     //简介
    @SerializedName("feature")
    val feature: String? = null,
    @SerializedName("careKnowledge")
    val careKnowledge: String? = null,   //养护知识
    @SerializedName("feedPoints")
    val feedPoints: String? = null,      //喂养要点
    @SerializedName("imageURL")
    val imageURL: MutableList<String> = mutableListOf(),
    @SerializedName("characterFeature")    //性格特点
    val characterFeature: String? = null
)
