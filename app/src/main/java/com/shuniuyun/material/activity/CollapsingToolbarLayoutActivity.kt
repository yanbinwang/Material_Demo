package com.shuniuyun.material.activity

import android.os.Bundle
import android.view.WindowManager
import com.shuniuyun.material.R

/**
 * author:wyb
 */
class CollapsingToolbarLayoutActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //透明状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collapsingtoolbarlayout)
    }
}