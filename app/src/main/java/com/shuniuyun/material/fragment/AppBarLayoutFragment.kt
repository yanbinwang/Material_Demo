package com.shuniuyun.material.fragment

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shuniuyun.material.R
import com.shuniuyun.material.activity.AppBarLayoutDetailActivity
import com.shuniuyun.material.adapter.TestAdapter
import com.shuniuyun.material.model.TestModel
import java.util.*

/**
 * 如果需要翻页滚动且隐藏标题，根据网上做法，只有在布局外用NestedScrollVie（最外层父级）可使用
 * @author wyb
 */
class AppBarLayoutFragment : Fragment() {
    private val mData by lazy { ArrayList<TestModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context)
            .inflate(R.layout.fragment_appbarlayout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (i in 0..19) {
            mData.add(TestModel("标题$i", "简介$i"))
        }
        val mRecycler = view.findViewById(R.id.mList) as RecyclerView
        mRecycler.setHasFixedSize(true)
        mRecycler.layoutManager = GridLayoutManager(context, 1) //设置一行设定是2个占位
        //说是如果item的高度固定不变，设置这个属性能提高性能，RecyclerView保持固定的大小
        val mAdapter = TestAdapter(mData)
        mAdapter.itemOnClickListener = View.OnClickListener { v: View? ->
//            int position = Integer.parseInt(v.getTag().toString());
            val intent = Intent(context, AppBarLayoutDetailActivity::class.java)
            if (v is ImageView) {
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context as Activity?, v, "mItem").toBundle())
            } else {
                startActivity(intent)
            }
        }
        mRecycler.adapter = mAdapter
    }

//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        for (i in 0..19) {
//            mData.add(TestModel("标题$i", "简介$i"))
//        }
//        val mRecycler = childView?.findViewById(R.id.mList) as RecyclerView
//        mRecycler.setHasFixedSize(true)
//        mRecycler.layoutManager = GridLayoutManager(context, 1) //设置一行设定是2个占位
//        //说是如果item的高度固定不变，设置这个属性能提高性能，RecyclerView保持固定的大小
//        val mAdapter = TestAdapter(mData)
//        mAdapter.itemOnClickListener = View.OnClickListener { v: View? ->
////            int position = Integer.parseInt(v.getTag().toString());
//            val intent = Intent(context, AppBarLayoutDetailActivity::class.java)
//            if (v is ImageView) {
//                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context as Activity?, v, "mItem").toBundle())
//            } else {
//                startActivity(intent)
//            }
//        }
//        mRecycler.adapter = mAdapter
//    }

}