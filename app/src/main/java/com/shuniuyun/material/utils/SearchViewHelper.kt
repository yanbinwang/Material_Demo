package com.shuniuyun.material.utils

import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import com.shuniuyun.material.R

/**
 * 安卓原生搜索工具类
 * <style name="searchStyle">
 *  <item name="android:textSize">12sp</item>
 * </style>
 *
 * <androidx.appcompat.widget.SearchView
 *  android:id="@+id/search"
 *  android:layout_width="match_parent"
 *  android:layout_height="50dp"
 *  android:layout_weight="1"
 *  android:theme="@style/searchStyle" />
 */
object SearchViewHelper {

    fun initialize(searchView: SearchView) {
        val context = searchView.context
        searchView.apply {
            //搜索图标是否显示在搜索框内
            setIconifiedByDefault(true)
            //设置搜索框展开时是否显示提交按钮，可不显示
            isSubmitButtonEnabled = true
            //让键盘的回车键设置成搜索
            imeOptions = EditorInfo.IME_ACTION_SEARCH
            //设置提示词
            queryHint = "请输入关键字"
        }
        //设置输入框文字颜色
        val editText = searchView.findViewById(androidx.appcompat.R.id.search_src_text) as EditText
        editText.apply {
            setHintTextColor(ContextCompat.getColor(context, R.color.white))
            setTextColor(ContextCompat.getColor(context, R.color.white))
            setOnEditorActionListener { _, actionId, _ ->
                //让键盘的回车键设置成搜索
                searchView.imeOptions = EditorInfo.IME_ACTION_SEARCH
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Toast.makeText(context, editText.text, Toast.LENGTH_SHORT).show()
                    searchView.onActionViewCollapsed()
                }
                false
            }
        }
    }

}