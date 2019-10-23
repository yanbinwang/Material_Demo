package com.shuniuyun.material.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shuniuyun.material.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.mBtn:
                intent = new Intent(MainActivity.this, TabLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.mBtn2:
                intent = new Intent(MainActivity.this, SnackBarActivity.class);
                startActivity(intent);
                break;
            case R.id.mBtn3:
                intent = new Intent(MainActivity.this, AppBarLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.mBtn4:
                intent = new Intent(MainActivity.this, CollapsingToolbarLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.mBtn5:
                intent = new Intent(MainActivity.this, BottomSheetBehaviorActivity.class);
                startActivity(intent);
                break;
            case R.id.mBtn6:
                intent = new Intent(MainActivity.this, BottomSheetDialogActivity.class);
                startActivity(intent);
                break;
        }
    }
}
