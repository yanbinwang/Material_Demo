package com.shuniuyun.material.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.shuniuyun.material.R

/**
 *  Created by wangyanbin
 *  底部弹出窗体工具类
 */
@SuppressLint("StaticFieldLeak")
object BottomSheetDialogHelper {
    private var sheetDialog: BottomSheetDialog? = null

    fun initialize(context: Context, resource: Int) {
        sheetDialog = BottomSheetDialog(context)
        sheetDialog?.setContentView(LayoutInflater.from(context).inflate(resource, null, false))
        val behavior = BottomSheetBehavior.from(sheetDialog?.delegate?.findViewById(R.id.design_bottom_sheet)!!)
        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    sheetDialog?.dismiss()
                    behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }

    fun isShowing() = sheetDialog?.isShowing ?: false

    fun show() {
        if (!isShowing()) sheetDialog?.show()
    }

    fun dismiss() {
        if (isShowing()) sheetDialog?.dismiss()
    }

}