package com.shuniuyun.material.fragment

import android.annotation.SuppressLint
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
@SuppressLint("SetTextI18n")
class TabLayoutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return LayoutInflater.from(context).inflate(R.layout.fragment_tablayout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val page = arguments?.getInt("page", 0) ?: 0
        val test = view.findViewById<TextView>(R.id.test)
//        test?.text = "第1页"
        test?.text = "第${page + 1}页"
    }

}