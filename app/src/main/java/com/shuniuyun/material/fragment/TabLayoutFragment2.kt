package com.shuniuyun.material.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.shuniuyun.material.R

/**
 *  Created by wangyanbin
 */
class TabLayoutFragment2 : Fragment() {
    private var childView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        childView = LayoutInflater.from(context).inflate(R.layout.fragment_tablayout, container, false)
        return childView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val test = childView?.findViewById<TextView>(R.id.test)
        test?.text = "第2页"
    }

}