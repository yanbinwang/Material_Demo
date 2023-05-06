package com.shuniuyun.material.provider

import android.content.Context
import android.util.Log
import android.view.SubMenu
import android.view.View
import android.widget.Toast
import androidx.core.view.ActionProvider
import com.shuniuyun.material.R

/**
 *  Created by wangyanbin
 *  分享菜单二级展开
 */
class ShareProvider(context: Context) : ActionProvider(context) {

    override fun onCreateActionView(): View {
//        return null
        return View(context)
    }

    override fun hasSubMenu(): Boolean {
        return true
    }

    //show出的2个小标签设置图片
    override fun onPrepareSubMenu(subMenu: SubMenu) {
        Log.v("MyActionProvider", "onPrepareSubMenu")
        subMenu.apply {
            //清空之前的配置
            clear()
            //添加两个子菜单
            add("微信")?.setIcon(R.mipmap.ic_launcher)?.setOnMenuItemClickListener {
                Toast.makeText(context, "微信点击", Toast.LENGTH_SHORT).show()
                false
            }
            add("微博")?.setIcon(R.mipmap.ic_launcher)?.setOnMenuItemClickListener {
                Toast.makeText(context, "微博点击", Toast.LENGTH_SHORT).show()
                false
            }
        }
    }

}