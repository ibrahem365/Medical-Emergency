package com.example.medical_application;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    //ItemHolder is the type of my ViewHolder

    // ArrayList of item and constructer
    ArrayList<Item> items;

    public ItemAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the Item design and send to a view holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bloodbank_items,null,false);
        ItemHolder holder = new ItemHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        // implement a item in this position in array
        Item i = items.get(position);
        // replace an image in holder into an image in array item
        holder.image1.setImageResource(i.getImage1());
        holder.txName.setText(i.getTxt1());
        holder.txAddress.setText(i.getTxt2());
        holder.txBloodType.setText(i.getTxt3());
        holder.phone.setText(i.getTxt5());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // Holder class for RecyclerView
    public class ItemHolder extends RecyclerView.ViewHolder {
        // Define variables for every content of item
        CircularImageView image1; Button btn; ImageView image2; TextView txName; TextView txBloodType;
        TextView txAddress; ImageView image3; ImageView image4; ImageView image5; TextView phone;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.image_1);
            btn = itemView.findViewById(R.id.btn);
            image2 = itemView.findViewById(R.id.image_2);
            txName = itemView.findViewById(R.id.txt_1);
            image3 = itemView.findViewById(R.id.image_3);
            txBloodType = itemView.findViewById(R.id.txt_2);
            image4 = itemView.findViewById(R.id.image_4);
            txAddress = itemView.findViewById(R.id.txt_3);
            image5=itemView.findViewById(R.id.image_5);
            phone=itemView.findViewById(R.id.txt_5);
        }
    }
}