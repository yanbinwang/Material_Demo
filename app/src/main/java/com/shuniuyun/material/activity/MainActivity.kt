package com.shuniuyun.material.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.shuniuyun.material.R

class MainActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mBtn -> startActivity(Intent(this@MainActivity, TabLayoutActivity::class.java))
            R.id.mBtn2 -> startActivity(Intent(this@MainActivity, SnackBarActivity::class.java))
            R.id.mBtn3 -> startActivity(Intent(this@MainActivity, AppBarLayoutActivity::class.java))
            R.id.mBtn4 -> startActivity(Intent(this@MainActivity, CollapsingToolbarLayoutActivity::class.java))
            R.id.mBtn5 -> startActivity(Intent(this@MainActivity, BottomSheetBehaviorActivity::class.java))
            R.id.mBtn6 -> startActivity(Intent(this@MainActivity, BottomSheetDialogActivity::class.java))
        }
    }

}