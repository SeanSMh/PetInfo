package com.sean.petinfo.api

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.*
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
        loadError: (Int) -> Unit,
        loadFailure: (Throwable) -> Unit
    ) {

        val requestJson = JSONObject()
        requestJson
            .put("page", 1)
            .put("pageSize", 30)
        val requestBody = RequestBody.create(mediaType, requestJson.toString())

        //结合suspend关键字
        try {
            val petListInfo = withContext(Dispatchers.IO) {
                return@withContext netApiService?.getPetList2(requestBody)
            }
            //成功的时候处理逻辑
            if (petListInfo != null) {
                withContext(Dispatchers.Main) {   //主线程处理数据
                    loadSuccess.invoke(petListInfo)
                }
            }
        } catch (e: Exception) {
            //失败的时候处理逻辑
            when(e) {
                is HttpException -> {
                    withContext(Dispatchers.Main) {
                        loadError.invoke(e.code())
                    }
                }
            }
        }

        /*netApiService?.getPetList(requestBody)?.enqueue(object : Callback<PetListInfo> {
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

        })*/
    }
}