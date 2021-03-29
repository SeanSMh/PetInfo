package com.sean.petinfo.api

/**
 * Author: Sean-Shen
 * Date: 2021/3/4
 * Desc:
 */
class NetApiImpl {
    companion object {
        fun setNetType(type: Int) {
            val instance: NetApiImpl by lazy {
                NetApiImpl()
            }
        }
    }

    init {

    }
}