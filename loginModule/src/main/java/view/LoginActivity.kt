package view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sean.loginmodule.R

/**
 * Author: Sean-Shen
 * Date: 2021/4/14
 * Desc: 登录界面
 */
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}