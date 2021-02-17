package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class new_report extends AppCompatActivity {
    int counter=0;
    ImageView plus;
    ImageView minus;
    TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_report);
        plus=findViewById(R.id.p);
        minus=findViewById(R.id.m);
        count=findViewById(R.id.c);
count.setText(counter +" ");
plus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        counter ++;
        count.setText(counter+" ");
    }
});
minus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        counter--;
        count.setText(counter+" ");
    }
});
    }
}