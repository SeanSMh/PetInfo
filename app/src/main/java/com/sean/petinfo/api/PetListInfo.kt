package com.sean.petinfo.api

import com.google.gson.annotations.SerializedName

/**
 * Author: Sean-Shen
 * Date: 2021/3/4
 * Desc: 网络请求数据实体类
 */
data class PetListInfo(
    @SerializedName("statusCode") val statusCode: String? = null,
    @SerializedName("desc") val desc: String? = null,
    @SerializedName("result") val result: ResultInfo? = null
)

data class ResultInfo(
    @SerializedName("petFamilyList") val petFamilyListInfo: MutableList<PetFamilyListInfo>? = mutableListOf(),
    @SerializedName("totalCount") val totalCount: String? = null
)

data class PetFamilyListInfo(
    @SerializedName("petID") val petId: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("engName") val engName: String? = null,
    @SerializedName("price") val price: String? = null,
    @SerializedName("coverURL") val coverUrl: String? = null
)
