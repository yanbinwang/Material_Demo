package com.shuniuyun.material.activity

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HIDDEN
import com.shuniuyun.material.R

/**
 * author:wyb
 */
class BottomSheetBehaviorActivity : BaseActivity(), View.OnClickListener {
    private var behavior: BottomSheetBehavior<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottomsheetbehavior)
        initView()
        initEvent()
    }

    private fun initView() {
        //拿到对应的BottomSheetBehavior
        behavior = BottomSheetBehavior.from(findViewById(R.id.nsv_bottom_sheet))
        behavior?.state = STATE_HIDDEN
    }

    private fun initEvent() {
        behavior?.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                //bottomSheet状态的改变，根据slideOffset可以做一些动画
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                //拖拽中的回调，根据slideOffset可以做一些动画
            }
        })
    }

    override fun onClick(v: View) {
        if (behavior?.state == STATE_HIDDEN) behavior?.setState(STATE_EXPANDED) else behavior?.setState(STATE_HIDDEN)
    }

}