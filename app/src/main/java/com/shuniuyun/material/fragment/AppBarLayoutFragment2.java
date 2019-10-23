package com.shuniuyun.material.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shuniuyun.material.R;


/**
 * 如果需要翻页滚动且隐藏标题，根据网上做法，只有在布局外用NestedScrollVie（最外层父级）可使用
 *
 * @author wyb
 */
public class AppBarLayoutFragment2 extends Fragment {
    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_appbarlayout2, container, false);
        return view;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
