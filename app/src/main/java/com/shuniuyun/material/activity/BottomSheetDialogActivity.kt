package com.shuniuyun.material.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.shuniuyun.material.R
import com.shuniuyun.material.utils.SheetDialogFactory

/**
 * author:wyb
 * 弹出一个可上下拉伸的弹框，内容可自定义
 */
class BottomSheetDialogActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var fullSheetDialog: SheetDialogFactory.FullSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottomsheetdialog)
        initView()
    }

    private fun initView() {
//        SheetDialogFactory.initialize(this, R.layout.view_bottomsheetdialog)
        fullSheetDialog = SheetDialogFactory.create(this, R.layout.view_bottomsheetdialog)
    }

    override fun onClick(v: View) {
        if (!fullSheetDialog.isShowing) fullSheetDialog.show()
    }

}