package com.sexyhair.demokotlinvar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.sexyhair.demokotlinvar.View.DemoViewActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast





class MainActivity : AppCompatActivity() {

    val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListener()
        setViewListener()
    }

    fun setViewListener(){
        btn_main_view.setOnClickListener {
            var intent = Intent(this,DemoViewActivity::class.java)
            startActivity(intent)
        }
    }

    fun setListener(){
        /**
         * 变量
         */
        btn_main_var.setOnClickListener {
            var intent = Intent(this,DemoVarActivity::class.java)
            startActivity(intent)

        }
        /**
         * 容器
         */
        btn_main_collect.setOnClickListener {
            var intent = Intent(this,DemoCollectionActivity::class.java)
            startActivity(intent)

        }
        /**
         * 控制语句
         */
        btn_main_control.setOnClickListener {
            var intent = Intent(this,DemoControlActivity::class.java)
            startActivity(intent)

        }
        /**
         * 函数
         */
        btn_main_fun.setOnClickListener {
            var intent = Intent(this,DemoFunActivity::class.java)
            startActivity(intent)

        }
        /**
         * 类和对象
         */
        btn_main_class.setOnClickListener {
            var intent = Intent(this,DemoFunActivity::class.java)
            startActivity(intent)

        }
    }




}
