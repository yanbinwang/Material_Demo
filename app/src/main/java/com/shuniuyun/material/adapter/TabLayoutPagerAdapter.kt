package com.shuniuyun.material.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shuniuyun.material.fragment.TabLayoutFragment

/**
 *  Created by wangyanbin
 */
class TabLayoutPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabLayoutFragment().apply {
                arguments = Bundle().apply {
                    putInt("page", 0)
                }
            }
            1 -> TabLayoutFragment().apply {
                arguments = Bundle().apply {
                    putInt("page", 1)
                }
            }
            else -> TabLayoutFragment().apply {
                arguments = Bundle().apply {
                    putInt("page", 2)
                }
            }
        }
    }

}