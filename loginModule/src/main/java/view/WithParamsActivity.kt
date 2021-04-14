package view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.sean.loginmodule.R
import com.sean.petinfo.RouteConstant

/**
 * Author: Sean-Shen
 * Date: 2021/4/14
 * Desc: 带参数跳转
 */
@Route(path = RouteConstant.paramsActivity)
class WithParamsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_params)
    }
}