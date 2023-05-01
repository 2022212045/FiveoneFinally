package com.example.fiveonefinally

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.fiveonefinally.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val mBinding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        initView()
    }

    private fun initView() {
        val name = intent.getStringExtra("key_username")
        val password = intent.getStringExtra("key_password")
        mBinding.registered.setOnClickListener {
            startActivity(Intent(this, RegisteredActivity::class.java))
        }
        mBinding.login.setOnClickListener {
            //1.获取输入框的值
            val name1 = mBinding.counter.text.toString()
            val password1 = mBinding.password.text.toString()

            //2.判断是否为空
            if(!TextUtils.isEmpty(name1) and !TextUtils.isEmpty(password1)){
                if((password.equals(password1))and(name.equals(name1))){
                    startActivity(Intent(this, MainActivity::class.java))
                }else{
                    Toast.makeText(this@LoginActivity,"登录失败", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"输入框不能为空", Toast.LENGTH_SHORT).show()
            }
        }
    }
}