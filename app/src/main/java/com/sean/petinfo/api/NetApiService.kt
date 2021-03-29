package com.sean.petinfo.api

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Author: Sean-Shen
 * Date: 2021/3/4
 * Desc:
 */
interface NetApiService {

    /**
     * 获取宠物列表
     */
    @POST("common/smallPetFamily/querySmallPetList?apiKey=4GJma8H9e9bddf4d77e6c2a4a2958608634cfd40d44b2b3")
    fun getPetList(@Body requestBody: RequestBody): Call<PetListInfo>

    /**
     * 获取单个宠物详情
     */
    fun getPetDetail()
}