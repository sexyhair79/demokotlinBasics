package com.sexyhair.demokotlinvar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DemoVarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_var)
        var arrs: IntArray = intArrayOf(1, 12, 3, 45, 557)
        var strs: Array<String> = arrayOf("32", "efa", "vzdg")
        var arrs1: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6)
        arrs1.forEach {Log.i("VarTo", "${it.toInt()}")  }
        testVarTo()
    }
    fun testVarTo() {
        var b: Byte = 127
        var b1: Byte = 26
        var t = b + b1 //b+b1的值是在Int范围内，默认是Int类型了
//        var t : Byte = b+b1//报错
        Log.i("VarTo", "${t.toInt()}")
    }
}
