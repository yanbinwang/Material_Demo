package com.shuniuyun.material.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.shuniuyun.material.R

/**
 *  Created by wangyanbin
 *  底部弹出窗体工具类
 */
@SuppressLint("StaticFieldLeak")
object BottomSheetDialogHelper {
    private var full = false
    private var sheetDialog: MBottomSheetDialog? = null

    fun initialize(context: Context, resource: Int, full: Boolean = false) {
        this.full = full
        this.sheetDialog = MBottomSheetDialog(context)
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

    fun show() = run { if (!isShowing()) sheetDialog?.show() }

    fun dismiss() = run { if (isShowing()) sheetDialog?.dismiss() }

    private fun isShowing() = sheetDialog?.isShowing ?: false

    //默认展开即全屏
    private class MBottomSheetDialog(context: Context) : BottomSheetDialog(context) {
        override fun show() {
            super.show()
            if (full) {
                window?.apply {
                    val view = decorView.findViewById<View>(R.id.design_bottom_sheet)
                    val layoutParams = view.layoutParams
                    layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
                    view.layoutParams = layoutParams
                    BottomSheetBehavior.from(view).setState(BottomSheetBehavior.STATE_EXPANDED)
                }
            }
        }
    }

}