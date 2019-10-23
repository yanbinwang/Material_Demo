package com.shuniuyun.material.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.shuniuyun.material.R;
import com.shuniuyun.material.bean.TestBean;

import java.util.List;


/**
 * Created by android on 2017/5/10.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private List<TestBean> mData;
    public View.OnClickListener itemOnClickListener;

    public TestAdapter(List<TestBean> mData) {
        this.mData = mData;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent,false));
        return holder;
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.list_item_title.setText(mData.get(position).title);
        holder.list_item_des.setText(mData.get(position).des);
        holder.list_item_pic.setTag(String.valueOf(position));
        holder.list_item_pic.setOnClickListener(itemOnClickListener);
        holder.list_container.setTag(String.valueOf(position));
        holder.list_container.setOnClickListener(itemOnClickListener);
    }

    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout list_container;
        private TextView list_item_title;
        private TextView list_item_des;
        private ImageView list_item_pic;

        ViewHolder(View itemView) {
            super(itemView);
            list_container = itemView.findViewById(R.id.list_container);
            list_item_pic = itemView.findViewById(R.id.list_item_pic);
            list_item_title = itemView.findViewById(R.id.list_item_title);
            list_item_des = itemView.findViewById(R.id.list_item_des);
        }
    }

}
