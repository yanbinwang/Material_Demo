package com.shuniuyun.material.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.shuniuyun.material.R

/**
 * 首页功能展示
 */
class MainActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.item_btn -> startActivity(Intent(this@MainActivity, TabLayoutActivity::class.java))
            R.id.item_btn2 -> startActivity(Intent(this@MainActivity, SnackBarActivity::class.java))
            R.id.item_btn3 -> startActivity(Intent(this@MainActivity, AppBarLayoutActivity::class.java))
            R.id.item_btn4 -> startActivity(Intent(this@MainActivity, CollapsingToolbarLayoutActivity::class.java))
            R.id.item_btn5 -> startActivity(Intent(this@MainActivity, BottomSheetBehaviorActivity::class.java))
            R.id.item_btn6 -> startActivity(Intent(this@MainActivity, BottomSheetDialogActivity::class.java))
        }
    }

}