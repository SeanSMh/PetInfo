package com.sean.petinfo.api

import android.util.Log
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Author: Sean-Shen
 * Date: 2021/3/4
 * Desc: 网络初始化
 */
object NetApi {
    private var retrofit: Retrofit? = null
    private var netApiService: NetApiService? = null
    private val mediaType = MediaType.parse("application/json; charset=utf-8")

    init {
        retrofit = Retrofit.Builder().client(OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor {
                Log.e("Sean--->", it)
            }
        ).build())
            .baseUrl("https://api.apishop.net/")
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
        netApiService = retrofit?.create(NetApiService::class.java)
    }

    /**
     * 获取宠物列表
     */
    suspend fun getPetList(
        loadSuccess: (PetListInfo) -> Unit,
        loadError: () -> Unit,
        loadFailure: (Throwable) -> Unit
    ) {

        val requestJson = JSONObject()
        requestJson
            .put("page", 1)
            .put("pageSize", 30)
        val requestBody = RequestBody.create(mediaType, requestJson.toString())

        netApiService?.getPetList(requestBody)?.enqueue(object : Callback<PetListInfo> {
            override fun onResponse(call: Call<PetListInfo>, response: Response<PetListInfo>) {
                Log.e("Sean--->", "成功")
                response.body()?.let {
                    loadSuccess.invoke(it)
                }
            }

            override fun onFailure(call: Call<PetListInfo>, t: Throwable) {
                Log.e("Sean--->", "失败${t.toString()}")
                loadFailure.invoke(t)
            }

        })
    }
}