package com.sean.petinfo

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

/**
 * Author: Sean-Shen
 * Date: 2021/4/21
 * Desc: 监听所有Activity的生命周期变化
 */
class MyActivityCallbacks : Application.ActivityLifecycleCallbacks {
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Log.e("SeanA--->", "activity:$activity -> onCreate()")
    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {
        Log.e("SeanA--->", "activity:$activity -> onResumed()")
    }

    override fun onActivityPaused(activity: Activity) {
        Log.e("SeanA--->", "activity:$activity -> onPaused()")
    }

    override fun onActivityStopped(activity: Activity) {
        Log.e("SeanA--->", "activity:$activity -> onStopped()")
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {
        Log.e("SeanA--->", "activity:$activity -> onDestroyed()")
    }
}