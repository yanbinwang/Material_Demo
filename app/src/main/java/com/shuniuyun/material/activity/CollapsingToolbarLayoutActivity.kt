package com.shuniuyun.material.activity

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.shuniuyun.material.R

/**
 * author:wyb
 * 可折叠缩放的标题，拉伸后顶部图片浮现，折叠后只展示标题
 */
class CollapsingToolbarLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsingtoolbarlayout)
    }

}