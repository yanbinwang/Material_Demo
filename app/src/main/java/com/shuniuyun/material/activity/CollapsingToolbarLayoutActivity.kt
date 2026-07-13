package com.shuniuyun.material.activity

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.shuniuyun.material.R
import kotlin.math.abs

/**
 * author:wyb
 * 可折叠缩放的标题，拉伸后顶部图片浮现，折叠后只展示标题
 *
 * 1. 展开态标题距左侧的距离
 * 设置 app:expandedTitleMarginStart="48dp"，这个值就是展开时标题左边距。改成想要的值即可，比如想更靠左就改小：
 * app:expandedTitleMarginStart="16dp"
 * app:expandedTitleMarginEnd="16dp"   <!-- 右侧同理 -->
 * app:expandedTitleMarginBottom="32dp" <!-- 底部距离也可调 -->
 *
 * 2. 展开态标题大小
 * app:expandedTitleTextAppearance="@style/TextAppearance.ExpandedTitle"
 * 然后在 styles.xml 中定义：
 * <style name="TextAppearance.ExpandedTitle" parent="TextAppearance.MaterialComponents.Headline5">
 *     <item name="android:textSize">28sp</item>
 *     <item name="android:textColor">@android:color/white</item>
 *     <item name="android:textStyle">bold</item>
 * </style>
 *
 * 3. 折叠后标题居中
 * 写了 app:collapsedTitleGravity="center_horizontal"，但要确保 Toolbar 没有默认 contentInset 把标题往右推，需新增：
 * app:contentInsetLeft="0dp"
 * app:contentInsetStart="0dp"
 * 这两步配合起来，折叠后标题就会真正水平居中。如果还偏，检查是否设置了导航图标（返回箭头），它会占用左侧空间导致视觉不居中。
 *
 * 4. 折叠后标题大小
 * app:collapsedTitleTextAppearance="@style/TextAppearance.CollapsedTitle"
 * <style name="TextAppearance.CollapsedTitle" parent="TextAppearance.MaterialComponents.Subtitle1">
 *     <item name="android:textSize">18sp</item>
 *     <item name="android:textColor">@android:color/white</item>
 * </style>
 *
 * 展开态左间距	    expandedTitleMarginStart	  16dp
 * 展开态字号/样式	    expandedTitleTextAppearance	  自定义 style
 * 折叠态居中	        collapsedTitleGravity	      center_horizontal
 * 折叠态字号/样式	    collapsedTitleTextAppearance  自定义 style
 * 折叠态背景色	    contentScrim	              @color/black
 * 展开态标题渐变遮罩	scrimVisibleHeightTrigger	  120dp（可选）
 */
class CollapsingToolbarLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        setContentView(R.layout.activity_collapsingtoolbarlayout)
        val appbar = findViewById<AppBarLayout>(R.id.appbar)
        appbar.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            private var isCollapsed = false
            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                val totalRange = appBarLayout?.totalScrollRange ?: return
                val currentlyCollapsed = abs(verticalOffset) < totalRange
                if (currentlyCollapsed != isCollapsed) {
                    isCollapsed = currentlyCollapsed
                    if (isCollapsed) {
                        Log.d("wyb", "展开")
                    } else {
                        Log.d("wyb", "折叠")
                    }
                }
            }
        })
    }

}