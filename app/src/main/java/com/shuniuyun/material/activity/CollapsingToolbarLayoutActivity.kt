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
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        setContentView(R.layout.activity_collapsingtoolbarlayout)
        val appbar = findViewById<AppBarLayout>(R.id.appbar)
        appbar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            private var isCollapsed = false
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                val totalRange = appBarLayout?.totalScrollRange ?: return
                val currentlyCollapsed = abs(verticalOffset) < totalRange
                if (currentlyCollapsed != isCollapsed) {
                    isCollapsed = currentlyCollapsed
                    if (isCollapsed) {
                        Log.d("wyb", "展开")
                    } else {
                        Log.d("wyb", "折叠")
                    }
                }
            }
        })
    }

}