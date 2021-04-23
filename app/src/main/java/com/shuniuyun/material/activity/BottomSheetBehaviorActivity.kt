package com.shuniuyun.material.activity

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
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
    }

    private fun initView() {
//        // 拿到这个tab_layout对应的BottomSheetBehavior
//        mBottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.tab_layout));
        behavior = BottomSheetBehavior.from(findViewById(R.id.bottom_sheet))
        behavior?.state = BottomSheetBehavior.STATE_HIDDEN

//        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                //这里是bottomSheet 状态的改变，根据slideOffset可以做一些动画
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//                //这里是拖拽中的回调，根据slideOffset可以做一些动画
//            }
//        });
    }

    override fun onClick(v: View) {
        if (behavior?.state == BottomSheetBehavior.STATE_HIDDEN) {
            behavior?.setState(BottomSheetBehavior.STATE_EXPANDED)
        } else {
            behavior?.setState(BottomSheetBehavior.STATE_HIDDEN)
        }
    }
}