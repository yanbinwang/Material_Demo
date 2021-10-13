package com.shuniuyun.material.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shuniuyun.material.R

/**
 * 如果需要翻页滚动且隐藏标题，根据网上做法，只有在布局外用NestedScrollVie（最外层父级）可使用
 * @author wyb
 */
class AppBarLayoutFragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_appbarlayout2, container, false)
    }

}