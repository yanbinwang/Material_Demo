package com.shuniuyun.material.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.shuniuyun.material.R;
import com.shuniuyun.material.adapter.AppBarLayoutPagerAdapter;
import com.shuniuyun.material.provider.MyActionProvider;

/**
 * author:wyb
 */
public class AppBarLayoutActivity extends BaseActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbarlayout);
        initView();
        initEvent();
    }

    //头部需要应用的布局
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void initView() {
        toolbar = findViewById(R.id.toolBar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);
        //设置各个menu的标题---还可以.setIcon(R.drawable.ic_launcher)加入的图片会在字体上方
        tabLayout.addTab(tabLayout.newTab().setText("菜单1---适配器应用"));
        tabLayout.addTab(tabLayout.newTab().setText("菜单2---可折叠菜单"));
        //全局平铺---也可设置成不平铺类似网易新闻那种不停往后翻页的形式
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //未选中白色，选中灰色
        tabLayout.setTabTextColors(Color.GRAY, Color.WHITE);
        //选中底部线的颜色
        tabLayout.setSelectedTabIndicatorColor(Color.RED);
        //选中底部线的高度
        tabLayout.setSelectedTabIndicatorHeight(5);
        AppBarLayoutPagerAdapter adapter = new AppBarLayoutPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
    }

    public void initEvent() {
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));//建立关联
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        toolbar.setTitle("顶部ToolBar标题");//标题
        setSupportActionBar(toolbar);//建立关联，需要更改styles文件以及继承AppCompatActivity
        // 有些语句得写在setSupportActionBar 之后才有效果
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_revert);//左侧图片
        toolbar.setNavigationOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "点击了左侧按钮", Toast.LENGTH_LONG).show();
            finish();
        });
        //自定义菜单的按钮点击事件
        toolbar.setOnMenuItemClickListener(menuItem -> {
            int id = menuItem.getItemId();
            String msg = "";
            switch (id) {
                case R.id.action_search:
                    msg = "点击了右侧正数第一个action_search";
                    break;
                case R.id.action_intent:
                    msg = "点击了右侧正数第二个action_intent";
                    // 这个地方要注意使用这种方式增加actionprovider不然会报错
                    MenuItemCompat.setActionProvider(menuItem, new MyActionProvider(this));
                    //该类加入了2个新的按钮会通过点击show出来
                    break;
                default:
                    break;

            }
            Toast.makeText(AppBarLayoutActivity.this, msg, Toast.LENGTH_SHORT).show();
            return false;
        });
    }

}
