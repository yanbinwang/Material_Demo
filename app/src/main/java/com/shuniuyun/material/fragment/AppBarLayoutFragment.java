package com.shuniuyun.material.fragment;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shuniuyun.material.R;
import com.shuniuyun.material.activity.AppBarLayoutDetailActivity;
import com.shuniuyun.material.adapter.TestAdapter;
import com.shuniuyun.material.bean.TestBean;

import java.util.ArrayList;
import java.util.List;


/**
 * 如果希望子视图滑动时候隐藏头部则得使用NestedScrollView(如需要添加在其中添加集合，嵌套能放在scrollview中的listview等)。
 *
 * @author wyb
 */
public class AppBarLayoutFragment extends Fragment {
    private View view;
    private List<TestBean> mData = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_appbarlayout, container, false);
        return view;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        for (int i = 0; i < 20; i++) {
            TestBean tb = new TestBean();
            tb.title = "标题" + i;
            tb.des = "简介" + i;
            mData.add(tb);
        }
        RecyclerView mRecycler = view.findViewById(R.id.mList);
        mRecycler.setHasFixedSize(true);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 1);//设置一行设定是2个占位
        mRecycler.setLayoutManager(manager);
        //说是如果item的高度固定不变，设置这个属性能提高性能，RecyclerView保持固定的大小
        TestAdapter mAdapter = new TestAdapter(mData);

        mAdapter.itemOnClickListener = v -> {
//            int position = Integer.parseInt(v.getTag().toString());
            Intent intent = new Intent(getContext(), AppBarLayoutDetailActivity.class);
            if (v instanceof ImageView) {
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation((Activity) getContext(), v, "mItem").toBundle());
            } else {
                startActivity(intent);
            }
        };
        mRecycler.setAdapter(mAdapter);
    }
}
