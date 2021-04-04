package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class new_report extends AppCompatActivity {
    int counter=0;
    ImageView plus;
    ImageView minus;
    TextView count;
    int counter1=0;
    ImageView plus1;
    ImageView minus1;
    TextView count1;
    int counter2=0;
    ImageView plus2;
    ImageView minus2;
    TextView count2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_report);
        plus=findViewById(R.id.p);
        minus=findViewById(R.id.m);
        count=findViewById(R.id.c);
        plus1=findViewById(R.id.p1);
        minus1=findViewById(R.id.m1);
        count1=findViewById(R.id.c1);
        plus2=findViewById(R.id.p2);
        minus2=findViewById(R.id.m2);
        count2=findViewById(R.id.c2);

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
plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1 ++;
                count1.setText(counter1+" ");
            }
});
minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1--;
                count1.setText(counter1+" ");
            }
});
plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2 ++;
                count2.setText(counter2+" ");
            }
});
minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2--;
                count2.setText(counter2+" ");
            }
});

        








    }
}