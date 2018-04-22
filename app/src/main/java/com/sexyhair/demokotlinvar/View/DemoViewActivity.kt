package com.sexyhair.demokotlinvar.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.widget.Button
import com.sexyhair.demokotlinvar.R
import kotlinx.android.synthetic.main.activity_demo_view.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast

class DemoViewActivity : AppCompatActivity() , View.OnClickListener {

    //注意，使用快捷键重写粗来的方法View后是有？的表示v可以为null,不要就对进行非空判断要不就把？去掉
    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_view_clicInterface -> toast("您点击了此按钮")
            else -> toast("无法识别的动作")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_view)
        //内部类：操作比较复杂的
        btn_view_clickClass.setOnClickListener(MyClickListener())
        //接口：操作比较复杂的
        btn_view_clicInterface.setOnClickListener(this)
        //匿名内部类
        setListener()
        setCheckBox()
        setTextView()
    }

    private fun setTextView(){
        view_textTwinkle.text = "跑马灯效果跑马灯效果跑马灯效果跑马灯效果跑马灯效果跑马灯效果跑马灯效果跑马灯效果马灯效果马灯效果马灯效果马灯效果马灯效果"
        view_textTwinkle.gravity = Gravity.LEFT or Gravity.CENTER//or 取缔了Java中的|
        view_textTwinkle.ellipsize = TextUtils.TruncateAt.MARQUEE//从右向左滚动跑
        //此方法的xml属性，过时了
        view_textTwinkle.setSingleLine(true)

    }
    private fun setCheckBox(){
        view_checkBox.isChecked = false//默认不选中
        view_checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            view_checkBoxShow.text = "您${if(isChecked ) "选中了" else "未选中"}复选框"
        }
    }


    private fun setListener(){
        //匿名函数的方式
        btn_view_clickNoName.setOnClickListener {
            toast("您点击了此按钮")
        }

        btn_view_clickNoName.setOnLongClickListener {
            //v as Button 表示把View v 强制转成Button
            v -> longToast("您点击了此按钮${(v as Button).text}")
            true
        }


    }

    private inner class MyClickListener : View.OnClickListener{
        var lastClick = 0L
        override fun onClick(v: View) {
            //防止用户连续点击事件的
            if (System.currentTimeMillis() - lastClick < 800L) {
                toast("您连续点击")
                return
            }
            lastClick = System.currentTimeMillis()
            toast("您点击了此按钮")
        }
    }

}
