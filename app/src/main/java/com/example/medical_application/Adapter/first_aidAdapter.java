package com.example.medical_application.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.medical_application.R;
import com.example.medical_application.fa_info;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class first_aidAdapter extends BaseAdapter implements Filterable {
    private Context c;
    private int resource;
    private ArrayList<fa_info> fa_infos, fa_infos2;


    public first_aidAdapter(Context c, int resource, ArrayList<fa_info> fa_infos) {
        this.c = c;
        this.resource = resource;
        this.fa_infos = fa_infos;
        fa_infos2 = new ArrayList<>(fa_infos);
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
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(c).inflate(resource, null, false);
        }
        TextView tv_name = v.findViewById(R.id.item_title);
        ImageView iv_img = v.findViewById(R.id.item_image);
        TextView tv_disc = v.findViewById(R.id.item_disc);
        fa_info f = getItem(position);
        tv_name.setText(f.getName());
        iv_img.setImageResource(f.getImg());
        tv_disc.setText(f.getDisc());
        return v;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<fa_info> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(fa_infos2);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (fa_info fa_info3 : fa_infos2) {
                    String Name = c.getResources().getString((fa_info3.getName()));
                    if (Name.contains(filterPattern)) {
                        filteredList.add(fa_info3);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            if (results.values != null){

                fa_infos.clear();
                fa_infos.addAll((ArrayList) results.values);
                notifyDataSetChanged();
            }

        }
    };

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
}
