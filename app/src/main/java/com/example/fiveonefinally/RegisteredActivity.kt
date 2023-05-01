package com.example.fiveonefinally

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.fiveonefinally.databinding.ActivityRegisteredBinding

class RegisteredActivity : AppCompatActivity() {
    private val mBinding: ActivityRegisteredBinding by lazy { ActivityRegisteredBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        //back()
        initView()
    }

    private fun initView() {

        //注册按钮点击事件
        mBinding.registered.setOnClickListener {
            //获取到输入框的值
            val name = mBinding.counter.text.trim()
            val password = mBinding.password.text.trim()
            //判断是否为空
            if (!TextUtils.isEmpty(name) and !TextUtils.isEmpty(password)) {
                Toast.makeText(RegisteredActivity(), "注册成功", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java).apply {
                    putExtra("key_username", name)
                    putExtra("key_password", password)
                }
// 启动登录界面，并传递参数
                startActivity(intent)
            } else {
                Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show()
                //Toast.makeText(this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

