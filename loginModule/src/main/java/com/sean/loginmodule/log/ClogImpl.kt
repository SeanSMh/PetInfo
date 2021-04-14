package com.sean.loginmodule.log

import android.util.Log
import com.sean.loginmodule.log.Clog

/**
 * Author: Sean-Shen
 * Date: 2021/4/14
 * Desc: 具体实现类
 */
class ClogImpl : Clog {
    override fun logV() {
        Log.v("Sean", "v")
    }

    override fun logE() {
        Log.v("Sean", "e")
    }

    override fun logD() {
        Log.v("Sean", "d")
    }

    override fun logW() {
        Log.v("Sean", "w")
    }

    override fun logI() {
        Log.v("Sean", "i")
    }
}