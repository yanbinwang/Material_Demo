package com.shuniuyun.material.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shuniuyun.material.fragment.TabLayoutFragment
import com.shuniuyun.material.fragment.TabLayoutFragment2
import com.shuniuyun.material.fragment.TabLayoutFragment3

/**
 *  Created by wangyanbin
 */
class TabLayoutPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabLayoutFragment()
            1 -> TabLayoutFragment2()
            2 -> TabLayoutFragment3()
            else -> Fragment()
        }
    }

}