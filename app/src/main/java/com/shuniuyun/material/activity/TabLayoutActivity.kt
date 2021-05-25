package com.shuniuyun.material.activity

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.shuniuyun.material.R
import com.shuniuyun.material.adapter.TabLayoutPagerAdapter

/**
 * author:wyb
 */
class TabLayoutActivity : BaseActivity() {
    private val toolbar by lazy { findViewById<Toolbar>(R.id.toolBar) }
    private val tabLayout by lazy { findViewById<TabLayout>(R.id.tabLayout) }
    private val viewPager by lazy { findViewById<ViewPager>(R.id.viewpager) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout)
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
        tabLayout.addTab(tabLayout.newTab().setText("菜单1"))
        tabLayout.addTab(tabLayout.newTab().setText("菜单2"))
        tabLayout.addTab(tabLayout.newTab().setText("菜单3"))
        //全局平铺---也可设置成不平铺类似网易新闻那种不停往后翻页的形式
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        //未选中白色，选中灰色
        tabLayout.setTabTextColors(Color.GRAY, Color.WHITE)
        //使用app:tabIndicator="@drawable/layer_tab_line"替代
//        //选中底部线的颜色
//        tabLayout.setSelectedTabIndicatorColor(Color.RED)
//        //选中底部线的高度
//        tabLayout.setSelectedTabIndicatorHeight(5)
        val adapter = TabLayoutPagerAdapter(supportFragmentManager, tabLayout.tabCount)
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
        toolbar.setNavigationOnClickListener {
            Toast.makeText(applicationContext, "返回-关闭页面", Toast.LENGTH_LONG).show()
            finish()
        }
        //自定义菜单的按钮点击事件
        toolbar.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

}