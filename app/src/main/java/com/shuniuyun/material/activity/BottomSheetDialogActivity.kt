package com.shuniuyun.material.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.shuniuyun.material.R

/**
 * author:wyb
 */
class BottomSheetDialogActivity : BaseActivity(), View.OnClickListener {
    private val mBottomSheetDialog by lazy { BottomSheetDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottomsheetdialog)
        initView()
        initEvent()
    }

    private fun initView(){
        mBottomSheetDialog.setContentView(LayoutInflater.from(this).inflate(R.layout.view_bottomsheetdialog, null, false))
    }

    private fun initEvent(){
        val bottomSheetBehavior = BottomSheetBehavior.from(mBottomSheetDialog.delegate.findViewById(R.id.design_bottom_sheet)!!)
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    mBottomSheetDialog.dismiss()
                    bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {}
        })
    }

    override fun onClick(v: View) {
        if (mBottomSheetDialog.isShowing) {
            mBottomSheetDialog.dismiss()
        } else mBottomSheetDialog.show()
    }

}