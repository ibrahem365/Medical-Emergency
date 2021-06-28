package com.example.medical_application;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RepAdapter extends RecyclerView.Adapter<RepAdapter.ItemHolder> {
    //ItemHolder is the type of my ViewHolder
/*
    private RecyclerViewClickListener listener;
*/
    /*MainActivity activity= new MainActivity();
    String phoneNum1=activity.getPhoneNum() ;
    int pho = Integer.parseInt(phoneNum1);*/

    private  static  String Tag = "RecyclerView";
    private Context mContext;
    // ArrayList of item and constructer
    ArrayList<RepItem> repItems;

    public RepAdapter(Context mContext, ArrayList<RepItem> items) {
        this.mContext = mContext;
        this.repItems = items;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the Item design and send to a view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rep_rec_item,parent,false);
        ItemHolder holder = new ItemHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        // implement a item in this position in array
        RepItem i = repItems.get(position);
        // replace an image in holder into an image in array item
        // holder.image1.setImageResource(i.getImage1());
        holder.txOwnName.setText(i.getPatName());
        holder.txRepType.setText(i.getRepType());
        holder.txLoca.setText(i.getLocaTxt());
        holder.txMan.setText(i.getmTxt());
        holder.txWoman.setText(i.getwTxt());
        holder.txChild.setText(i.getChTxt());

    }

    @Override
    public int getItemCount() {
        return repItems.size();
    }

    /*public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }*/

    // Holder class for RecyclerView
    public class ItemHolder extends RecyclerView.ViewHolder{
        // Define variables for every content of item
        TextView txOwnName,txRepType,txLoca,txMan,txWoman,txChild;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            txOwnName = itemView.findViewById(R.id.repOwen);
            txRepType = itemView.findViewById(R.id.repType);
            txLoca = itemView.findViewById(R.id.repLOca);
            txMan = itemView.findViewById(R.id.numMan);
            txWoman = itemView.findViewById(R.id.numWoman);
            txChild = itemView.findViewById(R.id.numChild);

            itemView.findViewById(R.id.btnViewLOca).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    Intent i= new Intent(Intent.ACTION_VIEW);
//                    i.setData(Uri.parse("geo:"+txLoca.getText().toString()));
//                    mContext.startActivity(i);

                    Uri uri = Uri.parse("google.navigation:q="+txLoca.getText().toString()+"&mode=d");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                        mContext.startActivity(mapIntent);


                }
            });

        }
    }
}

