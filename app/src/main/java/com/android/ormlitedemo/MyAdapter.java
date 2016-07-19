package com.android.ormlitedemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/7/16.
 */
public class MyAdapter extends RecyclerView.Adapter<VH>{
    private List<Student> list;
    private OnRecyclerItemClickListener mOnRecyclerItemClickListener;
    private  OnRecyclerItemLongClickListener mOnRecyclerItemLongClickListener;

    public void setOnRecyclerItemLongClickListener(OnRecyclerItemLongClickListener onRecyclerItemLongClickListener) {
        mOnRecyclerItemLongClickListener = onRecyclerItemLongClickListener;
    }

    public void setOnRecyclerItemClickListener(OnRecyclerItemClickListener onRecyclerItemClickListener) {
        mOnRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=View.inflate(parent.getContext(),R.layout.item_vh,null);
        VH vh=new VH(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final VH holder, int position) {
        holder.tv.setText(list.get(position).toString());
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnRecyclerItemClickListener.onRecyclerItemClick(holder.getLayoutPosition());
            }
        });
        holder.tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mOnRecyclerItemLongClickListener.onRecyclerItemLongClick(holder.getLayoutPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface OnRecyclerItemClickListener{
        void onRecyclerItemClick(int position);
    }
    public interface OnRecyclerItemLongClickListener{
        void onRecyclerItemLongClick(int position);
    }
}
