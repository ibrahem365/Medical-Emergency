package com.example.medical_application;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
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
    ArrayList<Item> items;

    public ItemAdapter(Context mContext, ArrayList<Item> items) {
        this.mContext = mContext;
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
        // holder.image1.setImageResource(i.getImage1());
        holder.txName.setText(i.getTxt1());
        holder.txAddress.setText(i.getTxt2());
        holder.txBloodType.setText(i.getTxt3());
        holder.txPhone.setText(i.getTxt4());

        String imageUri=null;
        imageUri=i.getImage1();
        Picasso.get().load(imageUri).into(holder.image1);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    /*public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }*/

    // Holder class for RecyclerView
    public class ItemHolder extends RecyclerView.ViewHolder{
        // Define variables for every content of item
        CircularImageView image1; Button btn; ImageView image2; TextView txName; TextView txBloodType;
        TextView txAddress; ImageView image3; ImageView image4;ImageView image5; TextView txPhone;
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
            image5 = itemView.findViewById(R.id.image_5);
            txPhone = itemView.findViewById(R.id.txt_4);

            itemView.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:12345"));
                    mContext.startActivity(i);
                }
            });

        }

       /* @Override
        public void onClick(View view) {

        }*/
    }
}