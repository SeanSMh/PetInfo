package com.sean.petinfo

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * Author: Sean-Shen
 * Date: 2021/4/14
 * Desc: 项目初始化
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
        registerActivityLifecycleCallbacks(MyActivityCallbacks())
    }
}