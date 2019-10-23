package com.shuniuyun.material.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.shuniuyun.material.R;

/**
 * author:wyb
 */
public class BottomSheetBehaviorActivity extends BaseActivity implements View.OnClickListener {
    private BottomSheetBehavior behavior;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottomsheetbehavior);
        initView();
    }

    private void initView() {
//        // 拿到这个tab_layout对应的BottomSheetBehavior
//        mBottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.tab_layout));
        View bottomSheet = findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);

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

    @Override
    public void onClick(View v) {
        if (behavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
    }
}
