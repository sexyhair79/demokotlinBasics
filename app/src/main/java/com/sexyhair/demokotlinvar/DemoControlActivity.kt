package com.sexyhair.demokotlinvar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_demo_control.*
import kotlinx.android.synthetic.main.activity_main.*

class DemoControlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_control)
        controlIf()
        controlWhen()
        controlWhile()
    }


    /**
     * 控制语句：While 可以代替Java中的条件for循环
     */
    fun controlWhile(){
        var lists: MutableList<String> = mutableListOf("v", "fdsg", "sxfdhdfvsd", "sd", "dfd")
        btn_while.setOnClickListener {
            var str = ""

            var index = 0//初始化语句
            while(index < lists.size){//判断语句
                str = "${str}${index+1}--${lists.get(index)}\n"
                //增减语句
                index++
            }
            textShowControl.text = str;
        }
    }
    /**
     * 控制语句：When else,分支语句可以返回值
     */
    fun controlWhen(){
        var one = 2
        var count = 43
        btn_when.setOnClickListener {
            textShowControl.text  = when(count){
                0 -> "是Int类型，值为0"
                one,1,3,4,5,6,7,8,9 -> "是个位数"//分支语句可以是变量，多个常量使用","隔开
                one * 10 -> "是整十位数"//分支语句可以是运算表达式
                in 100 ..999 -> "是百位数"//分支语句可以是区间
                !in 0..999 -> "百位以上的数"
                else -> "不知道是几"
            }
            var str = textShowControl.text
            textShowControl.text = "${str}"+when(textShowControl.text){
                is String -> " --- 字符串类型"
                else -> "不知道什么类型"
            }
            //textView显示结果：不知道是几 --- 字符串类型
        }
    }

    /**
     * 控制语句：if,分支语句可以返回值
     */
    fun controlIf(){
        btn_if.setOnClickListener {
            var a = 23
            var b = 40
            //Java中if语句
//            var result :Boolean
//            if (a > b){
//                result = true
//            }else{
//                result = false
//            }
//             textShowControl.text = "${result}"

            //Kotlin中if else 语句：if else语句可以有返回值
            var result :Boolean  = if(a > b) true else false
            //Kotlin的类型推断功能
            var result1   = if(a > b) 1 else 2

            textShowControl.text = "${result}   类型推断：${result1}"
        }
    }

}
