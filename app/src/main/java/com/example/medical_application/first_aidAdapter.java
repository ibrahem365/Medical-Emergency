package com.example.medical_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class first_aidAdapter extends BaseAdapter{
     private Context c;
    private int resource;
    private ArrayList<fa_info>fa_infos;



    public first_aidAdapter (Context c, int resource, ArrayList<fa_info>fa_infos){
        this.c=c;
        this.resource=resource;
        this.fa_infos=fa_infos;
    }
    @Override
    public int getCount() {
        return fa_infos.size();
    }

    @Override
    public fa_info getItem(int position) {
        return fa_infos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= convertView;
        if (v==null){
            v= LayoutInflater.from(c).inflate(resource,null,false);
        }
        TextView tv_name=v.findViewById(R.id.item_title);
        ImageView iv_img=v.findViewById(R.id.item_image);
        fa_info f=getItem(position);
        tv_name.setText(f.getName());
       iv_img.setImageResource(f.getImg());
        return v;
    }





}
