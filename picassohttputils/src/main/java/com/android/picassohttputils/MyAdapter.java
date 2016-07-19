package com.android.picassohttputils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016/7/16.
 */
public class MyAdapter extends BaseAdapter{
    private Data data;

    public MyAdapter(Data data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.getList().size();
    }

    @Override
    public Object getItem(int position) {
        return data.getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if(convertView==null){
            convertView=View.inflate(parent.getContext(),R.layout.item_list,null);
            vh=new ViewHolder();
            vh.iv= (ImageView) convertView.findViewById(R.id.item_list_iv);
            vh.tv= (TextView) convertView.findViewById(R.id.item_list_tv);
            convertView.setTag(vh);
        }else {
            vh= (ViewHolder) convertView.getTag();
        }
        vh.tv.setText(data.getList().get(position).getTitle());
        Picasso.with(parent.getContext()).load(data.getList().get(position).getPic_url()).into(vh.iv);
        return convertView;
    }
    class ViewHolder {
        ImageView iv;
        TextView tv;
    }
}
