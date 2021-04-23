package com.shuniuyun.material.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.shuniuyun.material.fragment.TabLayoutFragment
import com.shuniuyun.material.fragment.TabLayoutFragment2
import com.shuniuyun.material.fragment.TabLayoutFragment3

/**
 *  Created by wangyanbin
 */
class TabLayoutPagerAdapter(fm: FragmentManager, private var tabNum: Int) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int {
        return tabNum
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TabLayoutFragment()
            1 -> TabLayoutFragment2()
            2 -> TabLayoutFragment3()
            else -> Fragment()
        }
    }

}