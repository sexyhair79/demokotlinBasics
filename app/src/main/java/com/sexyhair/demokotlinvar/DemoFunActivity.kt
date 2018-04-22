package com.sexyhair.demokotlinvar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
/**
 * 内联函数：有点参数传递的是父类，调用的时候给参数是子类
 * 因为Kotlin要求参数类型完全匹配
 */
inline fun <reified T : Number>  sum (array : Array<T>) : String{
    var str = ""
    for(it in array){
        str =  "$str $it,"
    }
    return str;
}

class DemoFunActivity : AppCompatActivity() {
    val tag = "DemoFunActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_fun)

        //注意调用的时候没有给参数
        Log.i(tag,get())//输出结果：你好--Kotlin
        //提供参数值，则覆盖参数的默认值
        Log.i(tag,get("hello world"))//输出结果：hello world--Kotlin

        /**
        输出结果：除了int外都是默认的参数
        Int类型参数值是：1
        String类型参数值是：你好
        Char类型参数值是：a
        Boolean类型参数值是：true
         */
        Log.i(tag,get1(1))//输出结果：hello world--Kotlin

        /**
        输出结果：除了int外,Boolean 类型的参数发生了改变，调用方法时flag = false既是命名参数
        Int类型参数值是：1
        String类型参数值是：你好
        Char类型参数值是：a
        Boolean类型参数值是：false
         */
        Log.i(tag,get1(1,flag = false))

        Log.i(tag,get2(1,3,4))//输出结果：Int类型参数值是： 1, 3, 4,

        /**
        输出结果：
        第1个参数数组的元素是：{ 1, 2, 3,}
        第2个参数数组的元素是：{ 11, 22, 33,}
        第3个参数数组的元素是：{ 111, 222, 333,}
         */
        Log.i(tag,get3(arrayOf(1,2,3), arrayOf(11,22,33), arrayOf(111,222,333)))

        /**
        输出结果：
        第1个参数数组的元素是：{ 1q, 2q, 3q,}
        第2个参数数组的元素是：{ 11q, 22q, 33q,}
        第3个参数数组的元素是：{ 111q, 222q, 333q,}
         */
        Log.i(tag,get4(listOf("1q","2q","3q"), listOf("11q","22q","33q"), listOf("111q","222q","333q")))



        Log.i(tag,sum(arrayOf(1,2,3,4,5)))

        Log.i(tag,sum(arrayOf(1.0,2.0,3.0,4.0,5.0)))

        sum(1,3)
        Log.i(tag,"${sum(1,3)}")
    }

    fun sum(a : Int ,b : Int) :Int = if(a >= 0 && b >= 0) a+b else Math.abs(a)+Math.abs(b)


    /**
     * 有参数，返回值为String类型的public方法
     */
    fun get2(vararg int :Int ) : String{
        var str = ""
        for(it in int){
            str =  "$str $it,"
        }
        return "Int类型参数值是：$str"
    }

    /**
     * 有参数，返回值为String类型的public方法
     */
    fun get3(vararg arrs :Array<Int> ) : String{
        var count = 1
        var t = ""
        for(it in arrs){
            //此时it表示的是一个数组参数
            var str = ""
            for(i in it){
                //此时i表示的是一个数组参数中的一个元素
                str =  "$str $i,"
            }
            var s = "第${count}个参数数组的元素是：{${str}}\n"
            count++;
            t = t +s

        }
        return t
    }


    /**
     * 有参数，返回值为String类型的public方法
     */
    fun get4(vararg arrs :List<String> ) : String{
        var count = 1
        var t = ""
        for(it in arrs){
            //此时it表示的是一个队列参数
            var str = ""
            for(i in it){
                //此时i表示的是一个数组参数中的一个元素
                str =  "$str $i,"
            }
            var s = "第${count}个参数数组的元素是：{${str}}\n"
            count++;
            t = t +s

        }
        return t
    }




    /**
     * 有参数，返回值为String类型的public方法
     */
    fun get1(int :Int ,str:String = "你好",char :Char = 'a', flag :Boolean = true) : String{
        //函数体
        return "Int类型参数值是：$int\nString类型参数值是：$str\nChar类型参数值是：$char\nBoolean类型参数值是：$flag"
    }



    /**
     * 有参数，无返回值
     * 参数1带问号，表示str参数可以是空值
     */
    fun set(str : String ?,int : Int,arr :Array<String>){
        //语句体
    }


    /**
     * 有参数，返回值为String类型的public方法
     */
    fun get(str:String = "你好") : String{
        //函数体
        return str+"--Kotlin"
    }


}
