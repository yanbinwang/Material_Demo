package com.shuniuyun.material.activity

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.shuniuyun.material.R
import com.shuniuyun.material.adapter.AppBarLayoutPagerAdapter

/**
 *  Created by wangyanbin
 */
class AppBarLayoutActivity : AppCompatActivity() {
    private val toolbar by lazy { findViewById<Toolbar>(R.id.toolBar); }
    private val tabLayout by lazy { findViewById<TabLayout>(R.id.tabLayout); }
    private val viewPager by lazy { findViewById<ViewPager2>(R.id.viewpager); }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appbarlayout)
        initView()
        initEvent()
    }

    private fun initView() {
        toolbar.apply {
            title = "ToolBar标题"
            setNavigationIcon(android.R.drawable.ic_menu_revert)
            setSupportActionBar(this)
        }
        tabLayout.apply {
            tabGravity = TabLayout.GRAVITY_FILL
            setTabTextColors(Color.GRAY, Color.WHITE)
            setSelectedTabIndicatorColor(Color.RED)
//          setSelectedTabIndicatorHeight(5)
        }
        viewPager.adapter = AppBarLayoutPagerAdapter(this)
    }

    private fun initEvent() {
        //建立关联
        val tabTitle = listOf("子菜单---适配器", "子菜单2---可折叠")
        TabLayoutMediator(tabLayout, viewPager, true) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
        toolbar.setNavigationOnClickListener {
            Toast.makeText(applicationContext, "点击返回按钮关闭页面", Toast.LENGTH_LONG).show()
            finish()
        }
        //自定义菜单的按钮点击事件
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                //设置了actionViewClass为SearchView后，点击事件不生效
//                R.id.action_search -> Toast.makeText(this, "点击搜索按钮", Toast.LENGTH_SHORT).show()
                //点击分享按钮，弹出自定义二级菜单
                R.id.action_intent -> Toast.makeText(this, "点击分享按钮", Toast.LENGTH_SHORT).show()
                //设置被叠在了3个点当中
                R.id.action_settings -> Toast.makeText(this, "点击设置按钮", Toast.LENGTH_SHORT).show()
            }
            false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

}