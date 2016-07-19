package com.android.ormlitedemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/16.
 */
public class VH extends RecyclerView.ViewHolder{
    public TextView tv;
    public VH(View itemView) {
        super(itemView);
        tv= (TextView) itemView.findViewById(R.id.item_tv);
    }
}
