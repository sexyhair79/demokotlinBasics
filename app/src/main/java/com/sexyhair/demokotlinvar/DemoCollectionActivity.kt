package com.sexyhair.demokotlinvar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_demo_collection.*
//有了这个导包，就是引进Kotlin的控件变量自动映射的功能，无序findViewById了
import kotlinx.android.synthetic.main.activity_main.*

class DemoCollectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_collection)
        //集合
        var sets: Set<String> = setOf("水星", "金星", "地球", "图形")
        setFor(sets)
        setForEach(sets)
//        setIterator(sets)
        //队列
        var lists: MutableList<String> = mutableListOf("v", "fdsg", "sxfdhdfvsd", "sd", "dfd")
        lists.add("af")
        listSortBy(lists)
        listIndex(lists)

        //映射
        map()
        mapAddE()
    }
    /**
     * 映射添加元素
     */
    fun mapAddE(){
        btn_mapAddE.setOnClickListener {
            var map :MutableMap<String ,String > = mutableMapOf()
            map.put("你好1","你好11")
            map.put("你好2","你好22")
            map.put("你好4","你好44")
            map["你好11"] = "你好11111"
            map["你好21"] = "你好22222"
            map.set("你好12","你好1111111111")
            map.set("你好23","你好2222222222")
            var str = ""
            for(it in map){
                //it表示的到的是键值对
                str = "${str}${it.key}--${it.value}\n"
            }
            textShow.setText(str)
        }
    }

    /**
     * 映射的声明初始化和遍历
     */
    fun map(){
        btn_map.setOnClickListener {
            var map :Map<String ,String > = mapOf(Pair("你好1","嗨，你好1"),Pair("你好2","嗨，你好2"))
            var str = ""
            for(it in map){
                //it表示的到的是键值对
                str = "${str}${it.key}--${it.value}\n"
            }
            textShow.setText(str)
        }
    }

    /**
     * 通过队列的下标数组遍历队列
     */
    fun listIndex(lists: List<String>){
        btn_list_index.setOnClickListener {
            //indices是队列的下标数组
            var str = ""
            for(item in lists.indices){
                str = "${str}${item + 1} .${lists.get(item)}\n"
            }
            textShow.setText(str)
        }
    }
    /**
     * 排序
     */
    fun listSortBy(lists: MutableList<String>) {
        btn_list_sortBy.setOnClickListener {
            lists.sortedBy { it.length }
            var str = ""
            for (item in lists) {
                str = "${str}${lists.indexOf(item) + 1} .${item}\n"
            }
            textShow.setText(str)
        }
    }

    /**
     * 使用迭代器遍历集合
     */
    fun setIterator(sets: Set<String>) {
        btn_set_iterator.setOnClickListener {
            var iterator = sets.iterator()
            var str = ""
            var index = 0
            while (iterator.hasNext()) {
                index++
                str = "${str}${index} .${it}\n"
            }
            textShow.setText(str)
        }
    }

    /**
     * 使用forEach遍历集合
     */
    fun setForEach(sets: Set<String>) {
        btn_set_Each.setOnClickListener {
            var str = ""
            var index = 0
            sets.forEach {
                index++
                str = "${str}${index} .${it}\n"
            }
            textShow.setText(str)
        }

    }

    /**
     * 使用for-in循环遍历集合
     */
    fun setFor(sets: Set<String>) {
        btn_set_for.setOnClickListener {
            var str = ""
            var index = 0
            for (item in sets) {
                index++
                str = "${str}${index} .${item}\n"
            }
            textShow.setText(str)
        }
    }



}
