package com.shuniuyun.material.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.shuniuyun.material.R

/**
 *  Created by wangyanbin
 *  底部弹出窗体工具类
 */
@SuppressLint("StaticFieldLeak")
object SheetDialogFactory {
//    private var full = false
//    private var fullSheetDialog: FullSheetDialog? = null
//
//    /**
//     * 创建并返回一个配置好的 FullSheetDialog
//     * 调用方自行持有引用，生命周期跟随调用方
//     */
//    fun initialize(context: Context, resource: Int, full: Boolean = false) {
//        this.full = full
//        this.fullSheetDialog = FullSheetDialog(context)
//        fullSheetDialog?.setContentView(LayoutInflater.from(context).inflate(resource, null, false))
//        val behavior = BottomSheetBehavior.from(fullSheetDialog?.delegate?.findViewById(R.id.design_bottom_sheet)!!)
//        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
//                    fullSheetDialog?.dismiss()
//                    behavior.state = BottomSheetBehavior.STATE_COLLAPSED
//                }
//            }
//
//            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
//        })
//    }

//    fun show() = run { if (!isShowing()) fullSheetDialog?.show() }
//
//    fun dismiss() = run { if (isShowing()) fullSheetDialog?.dismiss() }
//
//    private fun isShowing() = fullSheetDialog?.isShowing ?: false

    /**
     * 创建并返回一个配置好的 FullSheetDialog
     * 调用方自行持有引用，生命周期跟随调用方
     */
    fun create(context: Context, @LayoutRes layoutRes: Int, fullScreen: Boolean = false): FullSheetDialog {
        return FullSheetDialog(context, fullScreen).apply {
            setContentView(LayoutInflater.from(context).inflate(layoutRes, null, false))
            val bottomSheet = delegate.findViewById<View>(R.id.design_bottom_sheet)
            val behavior = bottomSheet?.let { BottomSheetBehavior.from(it) }
            behavior?.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                        dismiss()
                        // 重置为 COLLAPSED，避免下次 show 时状态异常
                        behavior.state = BottomSheetBehavior.STATE_COLLAPSED
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            })
        }
    }

    /**
     * 支持全屏展开的 BottomSheetDialog
     */
    class FullSheetDialog(context: Context, private val fullScreen: Boolean = false) : BottomSheetDialog(context) {
        override fun show() {
            super.show()
            if (fullScreen) {
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