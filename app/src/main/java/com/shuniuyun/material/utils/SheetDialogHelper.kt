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
object SheetDialogHelper {
    private var full = false
    private var fullSheetDialog: FullSheetDialog? = null

    fun initialize(context: Context, resource: Int, full: Boolean = false) {
        this.full = full
        this.fullSheetDialog = FullSheetDialog(context)
        fullSheetDialog?.setContentView(LayoutInflater.from(context).inflate(resource, null, false))
        val behavior = BottomSheetBehavior.from(fullSheetDialog?.delegate?.findViewById(R.id.design_bottom_sheet)!!)
        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    fullSheetDialog?.dismiss()
                    behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }

    fun show() = run { if (!isShowing()) fullSheetDialog?.show() }

    fun dismiss() = run { if (isShowing()) fullSheetDialog?.dismiss() }

    private fun isShowing() = fullSheetDialog?.isShowing ?: false

    /**
     * 默认展开即全屏
     */
    private class FullSheetDialog(context: Context) : BottomSheetDialog(context) {
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