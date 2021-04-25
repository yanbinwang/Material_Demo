package com.shuniuyun.material.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.shuniuyun.material.fragment.AppBarLayoutFragment
import com.shuniuyun.material.fragment.AppBarLayoutFragment2

/**
 *  Created by wangyanbin
 */
class AppBarLayoutPagerAdapter(fm: FragmentManager, private var tabNum: Int) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount() = tabNum

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AppBarLayoutFragment()
            1 -> AppBarLayoutFragment2()
            else -> Fragment()
        }
    }

}