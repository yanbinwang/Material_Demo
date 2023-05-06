package com.shuniuyun.material.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.shuniuyun.material.R
import com.shuniuyun.material.utils.SheetDialogHelper

/**
 * author:wyb
 * 弹出一个可上下拉伸的弹框，内容可自定义
 */
class BottomSheetDialogActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottomsheetdialog)
        initView()
    }

    private fun initView() {
        SheetDialogHelper.initialize(this, R.layout.view_bottomsheetdialog)
    }

    override fun onClick(v: View) {
        SheetDialogHelper.show()
    }

}