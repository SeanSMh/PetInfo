package com.sean.loginmodule.log

import com.sean.loginmodule.log.ClogImpl

/**
 * Author: Sean-Shen
 * Date: 2021/4/14
 * Desc: 代理类
 */
object ClogProxy : Clog {
    private var clogI: Clog? = null

    init {
        clogI = ClogImpl()   //持有委托类的对象
    }

    override fun logV() {
        clogI?.logV()
    }

    override fun logE() {
        clogI?.logE()
    }

    override fun logD() {
        clogI?.logD()
    }

    override fun logW() {
        clogI?.logW()
    }

    override fun logI() {
        clogI?.logI()
    }
}