package com.shuniuyun.material.fragment

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
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
import com.shuniuyun.material.bean.TestBean

/**
 * 如果需要翻页滚动且隐藏标题，根据网上做法，只有在布局外用NestedScrollVie（最外层父级）可使用
 * @author wyb
 *
 * 1. makeCustomAnimation
 * 效果：借助自定义的动画资源，达成 Activity 切换时的过渡效果。
 * 用法：
 * // 从activityA跳转到activityB时使用自定义动画
 * Intent intent = new Intent(activityA, activityB);
 * ActivityOptions options = ActivityOptions.makeCustomAnimation(
 *     activityA,
 *     R.anim.slide_in_right,  // 进入动画
 *     R.anim.slide_out_left   // 退出动画
 * );
 * ActivityCompat.startActivity(activityA, intent, options.toBundle());
 * 实现效果：新 Activity 从右侧滑入，旧 Activity 向左侧滑出。
 *
 * 2. makeScaleUpAnimation
 * 效果：新 Activity 从特定位置开始，进行缩放和淡入操作。
 * 用法：
 * // 从坐标(startX, startY)处以初始尺寸(startWidth, startHeight)开始缩放
 * ActivityOptions options = ActivityOptions.makeScaleUpAnimation(
 *     view,           // 动画起始的视图
 *     startX,         // X轴起始坐标
 *     startY,         // Y轴起始坐标
 *     startWidth,     // 初始宽度
 *     startHeight     // 初始高度
 * );
 * 实现效果：新 Activity 从指定点开始，逐渐放大到全屏
 *
 * 3. makeThumbnailScaleUpAnimation
 * 效果：以缩略图为基础，实现 Activity 的缩放过渡效果。
 * 用法：
 * // 共享缩略图的缩放动画
 * Bitmap thumbnail = getThumbnailBitmap(); // 获取缩略图
 * ActivityOptions options = ActivityOptions.makeThumbnailScaleUpAnimation(
 *     sourceView,     // 源视图
 *     thumbnail,      // 缩略图
 *     startX,         // 起始X坐标
 *     startY          // 起始Y坐标
 * );
 * 实现效果：新 Activity 从缩略图位置开始，逐步放大到全屏。
 *
 * 4. makeSceneTransitionAnimation
 * 效果：实现共享元素在不同 Activity 之间的平滑过渡。
 * 用法：
 * // 共享元素的场景过渡动画
 * Intent intent = new Intent(this, DetailActivity.class);
 * ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
 *     this,
 *     Pair.create(view1, "shared_element_name1"), // 共享元素1
 *     Pair.create(view2, "shared_element_name2")  // 共享元素2
 * );
 * ActivityCompat.startActivity(this, intent, options.toBundle());
 * 实现效果：共享元素在 Activity 切换时保持视觉连贯性，仿佛是同一个元素在移动或变换。
 *
 * 5. makeClipRevealAnimation
 * 效果：以圆形或矩形的方式，显示新 Activity。
 * 用法：
 * // 从指定位置开始的圆形显示动画
 * ActivityOptions options = ActivityOptions.makeClipRevealAnimation(
 *     targetView,     // 目标视图
 *     startX,         // 起始X坐标
 *     startY,         // 起始Y坐标
 *     width,          // 宽度
 *     height          // 高度
 * );
 * 实现效果：新 Activity 从指定点开始，像水波一样逐渐显示出来。
 *
 * 6. makeTaskLaunchBehind
 * 效果：在当前 Activity 的后面启动新的 Activity 任务。
 * 用法：
 * // 在当前Activity后面启动新任务
 * ActivityOptions options = ActivityOptions.makeTaskLaunchBehind();
 * startActivity(intent, options.toBundle());
 *
 * 7. setLaunchBounds
 * 效果：对 Activity 的启动区域进行限制。
 * 用法：
 * // 设置Activity的启动边界
 * ActivityOptions options = ActivityOptions.makeBasic();
 * options.setLaunchBounds(new Rect(left, top, right, bottom));
 * startActivity(intent, options.toBundle());
 */
class AppBarLayoutFragment : Fragment() {
    private val dataList by lazy { ArrayList<TestBean>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_appbarlayout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (i in 0..19) {
            dataList.add(TestBean("标题$i", "简介$i"))
        }
        val recyclerView = view.findViewById(R.id.rec) as RecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(context, 1) //设置一行设定是2个占位
        //说是如果item的高度固定不变，设置这个属性能提高性能，RecyclerView保持固定的大小
        val mAdapter = TestAdapter(dataList)
        mAdapter.itemOnClickListener = View.OnClickListener { v: View? ->
//            int position = Integer.parseInt(v.getTag().toString());
            val intent = Intent(context, AppBarLayoutDetailActivity::class.java)
            if (v is ImageView) {
                // 方式1 --- 无需配置sharedElementName
                // 从 ImageView 获取现有 Bitmap（避免重新解码资源）
                val drawable = v.drawable
                val bitmap = if (drawable is BitmapDrawable) {
                    drawable.bitmap
                } else {
                    null
                }
                val options = ActivityOptions.makeThumbnailScaleUpAnimation(v, bitmap, 0, 0).toBundle()
                startActivity(intent, options)
                // 方式2 --- 跳转页面需要对对应的view配置 android:transitionName="mItem"
//                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(context as Activity?, v, "mItem").toBundle())
            } else {
                startActivity(intent)
            }
        }
        recyclerView.adapter = mAdapter
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