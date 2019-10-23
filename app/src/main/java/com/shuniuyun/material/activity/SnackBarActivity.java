package com.shuniuyun.material.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;
import com.shuniuyun.material.R;

/**
 * author:wyb
 */
public class SnackBarActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, "FAB", Snackbar.LENGTH_LONG)
                .setAction("cancel", v1 -> {
                    // 这里的单击事件代表点击消除Action后的响应事件
                }).show();
    }
}
