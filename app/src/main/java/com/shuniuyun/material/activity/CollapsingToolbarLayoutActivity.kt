package com.shuniuyun.material.activity;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;

import com.shuniuyun.material.R;

/**
 * author:wyb
 */
public class CollapsingToolbarLayoutActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsingtoolbarlayout);
    }

}
