package com.example.medical_application;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class userAdapter extends ArrayAdapter<Number> {

    public userAdapter(@NonNull Context context, @NonNull ArrayList<Number> numbers1) {
        super(context,0 , numbers1);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.emgnumitem_layout,parent,false);
        }

        Number currentNumber = getItem(position);

        ImageView phone = (ImageView) listItemView.findViewById(R.id.phone);
        TextView title = (TextView) listItemView.findViewById(R.id.itemTitle);
        TextView number = (TextView) listItemView.findViewById(R.id.itemNumber);
        ImageView photo = (ImageView) listItemView.findViewById(R.id.itemPhoto);

        phone.setImageResource(currentNumber.getPhoneId());
        title.setText(currentNumber.getName());
        number.setText(currentNumber.getpNum());
        photo.setImageResource(currentNumber.getImageResourceId());

        return listItemView;
    }
}

