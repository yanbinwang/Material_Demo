package com.shuniuyun.material.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shuniuyun.material.R
import com.shuniuyun.material.model.TestModel

/**
 *  Created by wangyanbin
 */
class TestAdapter(private var mData: MutableList<TestModel>) : RecyclerView.Adapter<TestAdapter.ViewHolder>() {
    var itemOnClickListener: View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_test, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvItemTitle.text = mData[position].title
        holder.tvItemDes.text = mData[position].des
        holder.ivItemPic.tag = position.toString()
        holder.ivItemPic.setOnClickListener(itemOnClickListener)
        holder.llContainer.tag = position.toString()
        holder.llContainer.setOnClickListener(itemOnClickListener)
    }

    override fun getItemCount() = mData.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val llContainer: LinearLayout by lazy { itemView.findViewById(R.id.ll_container) }
        val ivItemPic: ImageView by lazy { itemView.findViewById(R.id.iv_item_pic) }
        val tvItemTitle: TextView by lazy { itemView.findViewById(R.id.tv_item_title) }
        val tvItemDes: TextView by lazy { itemView.findViewById(R.id.tv_item_des) }
    }

}