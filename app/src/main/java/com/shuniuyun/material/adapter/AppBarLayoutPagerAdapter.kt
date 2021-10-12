package com.shuniuyun.material.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shuniuyun.material.fragment.AppBarLayoutFragment
import com.shuniuyun.material.fragment.AppBarLayoutFragment2

/**
 *  Created by wangyanbin
 */
class AppBarLayoutPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AppBarLayoutFragment()
            1 -> AppBarLayoutFragment2()
            else -> Fragment()
        }
    }

}