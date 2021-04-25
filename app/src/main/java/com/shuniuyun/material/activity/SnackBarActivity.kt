package com.shuniuyun.material.activity

import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.shuniuyun.material.R

/**
 * author:wyb
 */
class SnackBarActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snack_bar)
    }

    override fun onClick(v: View) {
        Snackbar.make(v, "测试Snackbar", Snackbar.LENGTH_LONG)
            .setAction("取消") { }.show()
    }

}