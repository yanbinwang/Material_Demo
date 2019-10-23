package com.shuniuyun.material.provider;

import android.content.Context;
import android.util.Log;
import android.view.SubMenu;
import android.view.View;
import android.widget.Toast;

import androidx.core.view.ActionProvider;

import com.shuniuyun.material.R;


public class MyActionProvider extends ActionProvider {

    private Context context;

    public MyActionProvider(Context context) {
        super(context);
        this.context = context;

    }

    public View onCreateActionView() {
        return null;
    }

    public boolean hasSubMenu() {
        return true;
    }

    //show出的2个小标签设置图片
    public void onPrepareSubMenu(SubMenu subMenu) {
        Log.v("burning", "onPrepareSubMenu");
        subMenu.clear();
        subMenu.add("sub item1")
                .setIcon(R.mipmap.ic_launcher)
                .setOnMenuItemClickListener(
                        item -> {
                            Toast.makeText(context, "item1", Toast.LENGTH_SHORT).show();
                            return false;
                        });

        subMenu.add("sub item2")
                .setIcon(R.mipmap.ic_launcher)
                .setOnMenuItemClickListener(
                        item -> {
                            Toast.makeText(context, "item2", Toast.LENGTH_SHORT).show();
                            return false;
                        });

        super.onPrepareSubMenu(subMenu);
    }
}