package com.shuniuyun.material.activity

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.shuniuyun.material.R
import kotlin.math.abs

/**
 * author:wyb
 * 可折叠缩放的标题，拉伸后顶部图片浮现，折叠后只展示标题
 */
class CollapsingToolbarLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsingtoolbarlayout)
        val appbar = findViewById<AppBarLayout>(R.id.appbar)
        appbar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            private var isHide = false
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                val needHide = abs(verticalOffset) < (appBarLayout?.totalScrollRange ?: 0)
                if (needHide != isHide) {
                    isHide = needHide
                    //展开
                    if (needHide) {
                        Log.e("wyb","展开")
                        //折起
                    } else {
                        Log.e("wyb","折起")
                    }
                }
            }
        })
    }

}