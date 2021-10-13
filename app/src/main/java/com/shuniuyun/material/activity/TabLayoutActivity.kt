package com.shuniuyun.material.activity

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.*
import com.google.android.material.tabs.TabLayoutMediator
import com.shuniuyun.material.R
import com.shuniuyun.material.adapter.TabLayoutPagerAdapter
import com.shuniuyun.material.utils.SearchViewHelper

/**
 * author:wyb
 */
class TabLayoutActivity : BaseActivity() {
    private val toolbar by lazy { findViewById<Toolbar>(R.id.toolBar) }
    private val tabLayout by lazy { findViewById<TabLayout>(R.id.tabLayout) }
    private val viewPager by lazy { findViewById<ViewPager2>(R.id.viewpager) }

    private var searchView: SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout)
        initView()
        initEvent()
    }

    private fun initView() {
        toolbar.apply {
            title = "顶部ToolBar标题"//标题
            setNavigationIcon(android.R.drawable.ic_menu_revert)//左侧图片
            setSupportActionBar(toolbar)
        }
        tabLayout.apply {
//            //设置各个menu的标题---还可以.setIcon(R.drawable.ic_launcher)加入的图片会在字体上方
//            addTab(newTab().setText("菜单1"))
//            addTab(newTab().setText("菜单2"))
//            addTab(newTab().setText("菜单3"))
            tabGravity = GRAVITY_FILL//全局平铺---也可设置成不平铺类似网易新闻那种不停往后翻页的形式
            setTabTextColors(Color.GRAY, Color.WHITE)//未选中白色，选中灰色
            setSelectedTabIndicatorColor(Color.RED)//选中底部线的颜色-drawable配置背景色不管有，会被style的颜色替代，直接代码或xml配置
//          setSelectedTabIndicatorHeight(5)//选中底部线的高度-使用app:tabIndicator="@drawable/layer_tab_line"替代
        }
        val adapter = TabLayoutPagerAdapter(this)
        viewPager.adapter = adapter
        viewPager.getChildAt(0).overScrollMode = OVER_SCROLL_NEVER
    }

    private fun initEvent() {
        //建立关联
        val tabTitle = listOf("菜单1","菜单2","菜单3")
        TabLayoutMediator(tabLayout,viewPager,true) { tab, position -> tab.text = tabTitle[position] }.attach()
        toolbar.setNavigationOnClickListener {
            Toast.makeText(applicationContext, "点击关闭按钮", Toast.LENGTH_LONG).show()
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        //搜索的配置参数
        val searchMenuItem = menu.findItem(R.id.action_search)
//        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = searchMenuItem.actionView as SearchView
        SearchViewHelper.initialize(searchView!!)

////        searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))
//        //搜索图标是否显示在搜索框内
//        searchView?.setIconifiedByDefault(true)
//        //设置搜索框展开时是否显示提交按钮，可不显示
//        searchView?.isSubmitButtonEnabled = true
//        //让键盘的回车键设置成搜索
//        searchView?.imeOptions = EditorInfo.IME_ACTION_SEARCH
////        //搜索框是否展开，false表示展开
////        searchView?.setIconified(false)
////        //获取焦点
////        searchView?.setFocusable(true)
////        searchView?.requestFocusFromTouch()
//        //设置提示词
//        searchView?.queryHint = "请输入关键字"
//        //设置输入框文字颜色
//        val editText = searchView?.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
//        editText.setHintTextColor(ContextCompat.getColor(this, R.color.white))
//        editText.setTextColor(ContextCompat.getColor(this, R.color.white))
//        editText.setOnEditorActionListener { _, actionId, _ ->
//            //让键盘的回车键设置成搜索
//            searchView?.imeOptions = EditorInfo.IME_ACTION_SEARCH
//            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
//                //完成自己的事件
//                Toast.makeText(this, editText.text, Toast.LENGTH_SHORT).show()
//                searchView?.onActionViewCollapsed()
//            }
//            false
//        }
        return true
    }

}