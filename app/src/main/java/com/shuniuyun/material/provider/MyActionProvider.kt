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
 */
class MyActionProvider(context: Context) : ActionProvider(context) {
    override fun onCreateActionView(): View {
        return View(context)
    }

    override fun hasSubMenu(): Boolean {
        return true
    }

    //show出的2个小标签设置图片
    override fun onPrepareSubMenu(subMenu: SubMenu?) {
        Log.v("burning", "onPrepareSubMenu")
        subMenu?.clear()
        subMenu?.add("sub item1")
            ?.setIcon(R.mipmap.ic_launcher)
            ?.setOnMenuItemClickListener {
                Toast.makeText(context, "item1", Toast.LENGTH_SHORT).show()
                false
            }

        subMenu?.add("sub item2")
            ?.setIcon(R.mipmap.ic_launcher)
            ?.setOnMenuItemClickListener {
                Toast.makeText(context, "item2", Toast.LENGTH_SHORT).show()
                false
            }
        super.onPrepareSubMenu(subMenu)
    }

}