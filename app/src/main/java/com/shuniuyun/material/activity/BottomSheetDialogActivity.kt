package com.shuniuyun.material.activity

import android.os.Bundle
import android.view.View
import com.shuniuyun.material.R
import com.shuniuyun.material.utils.BottomSheetDialogHelper

/**
 * author:wyb
 */
class BottomSheetDialogActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottomsheetdialog)
        initView()
    }

    private fun initView() {
        BottomSheetDialogHelper.initialize(this, R.layout.view_bottomsheetdialog)
    }

    override fun onClick(v: View) {
        BottomSheetDialogHelper.shown()
    }

}