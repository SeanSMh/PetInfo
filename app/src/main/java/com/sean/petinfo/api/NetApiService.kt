package com.sean.petinfo.api

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Author: Sean-Shen
 * Date: 2021/3/4
 * Desc: 网络请求接口
 */
interface NetApiService {

    /**
     * 获取宠物列表
     */
    @POST("common/smallPetFamily/querySmallPetList?apiKey=4GJma8H9e9bddf4d77e6c2a4a2958608634cfd40d44b2b3")
    fun getPetList(@Body requestBody: RequestBody): Call<PetListInfo>

    /**
     * Retrofit 结合协程
     */
    @POST("common/smallPetFamily/querySmallPetList?apiKey=4GJma8H9e9bddf4d77e6c2a4a2958608634cfd40d44b2b3")
    suspend fun getPetList2(@Body requestBody: RequestBody): PetListInfo

    /**
     * 获取单个宠物详情
     */
    @GET("common/smallPetFamily/querySmallPetInfo?apiKey=4GJma8H9e9bddf4d77e6c2a4a2958608634cfd40d44b2b3")
    suspend fun getPetDetail(@Query("petID") petId: String): SinglePetInfo
}