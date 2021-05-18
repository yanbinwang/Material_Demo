package com.shuniuyun.material.activity

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuItemCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.shuniuyun.material.R
import com.shuniuyun.material.adapter.AppBarLayoutPagerAdapter
import com.shuniuyun.material.provider.MyActionProvider

/**
 *  Created by wangyanbin
 */
class AppBarLayoutActivity : BaseActivity() {
    private val toolbar by lazy { findViewById<Toolbar>(R.id.toolBar); }
    private val tabLayout by lazy { findViewById<TabLayout>(R.id.tabLayout); }
    private val viewPager by lazy { findViewById<ViewPager>(R.id.viewpager); }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appbarlayout)
        initView()
        initEvent()
    }

    private fun initView() {
        //标题
        toolbar.title = "顶部ToolBar标题"
        //建立关联，需要更改styles文件以及继承AppCompatActivity
        setSupportActionBar(toolbar)
        //有些语句得写在setSupportActionBar 之后才有效果
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_revert) //左侧图片
        //设置各个menu的标题---还可以.setIcon(R.drawable.ic_launcher)加入的图片会在字体上方
        tabLayout.addTab(tabLayout.newTab().setText("菜单1---适配器应用"))
        tabLayout.addTab(tabLayout.newTab().setText("菜单2---可折叠菜单"))
        //全局平铺---也可设置成不平铺类似网易新闻那种不停往后翻页的形式
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        //未选中白色，选中灰色
        tabLayout.setTabTextColors(Color.GRAY, Color.WHITE)
        //选中底部线的颜色
        tabLayout.setSelectedTabIndicatorColor(Color.RED)
        //选中底部线的高度
        tabLayout.setSelectedTabIndicatorHeight(5)
        val adapter = AppBarLayoutPagerAdapter(supportFragmentManager, tabLayout.tabCount)
        viewPager.adapter = adapter
    }

    private fun initEvent() {
        //建立关联
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        toolbar.setNavigationOnClickListener { v: View? ->
            Toast.makeText(applicationContext, "点击了左侧按钮", Toast.LENGTH_LONG).show()
            finish()
        }
        //自定义菜单的按钮点击事件
        toolbar.setOnMenuItemClickListener { menuItem: MenuItem ->
            var msg = ""
            when (menuItem.itemId) {
                R.id.action_search -> msg = "点击了右侧正数第一个action_search"
                R.id.action_intent -> {
                    msg = "点击了右侧正数第二个action_intent"
                    //这个地方要注意使用这种方式增加actionprovider不然会报错
                    MenuItemCompat.setActionProvider(menuItem, MyActionProvider(this))
                }
                else -> {}
            }
            Toast.makeText(this@AppBarLayoutActivity, msg, Toast.LENGTH_SHORT).show()
            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

}