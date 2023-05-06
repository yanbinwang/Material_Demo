package com.shuniuyun.material.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.shuniuyun.material.R

/**
 * author:wyb
 * 底部弹彩蛋的安卓新提示框
 */
class SnackBarActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar)
    }

    override fun onClick(v: View) {
        Snackbar.make(v, "Snackbar提示框测试", Snackbar.LENGTH_LONG).setAction("取消") { }.show()
    }

}