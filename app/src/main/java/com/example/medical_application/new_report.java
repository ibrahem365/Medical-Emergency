package com.example.medical_application;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.zip.Inflater;

public class new_report extends AppCompatActivity {

    int counter=0;
    FloatingActionButton plus;
    FloatingActionButton minus;
    TextView count;
    int counter1=0;
    FloatingActionButton plus1;
    FloatingActionButton minus1;
    TextView count1;
    int counter2=0;
    FloatingActionButton plus2;
    FloatingActionButton minus2;
    TextView count2;
    Button send;
    Button fa;
    TextView fa_text;
    Button bl;
    TextView bl_text;
    private AlertDialog.Builder dialogbuilder;
    private AlertDialog dialog;




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
        send=findViewById(R.id.send_btn);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup();
            }
        });


    }
    public void popup(){
        dialogbuilder=new AlertDialog.Builder(this);
        final View dilaog_sc=getLayoutInflater().inflate(R.layout.dialog,null);
        fa_text=findViewById(R.id.fa_text);
        fa=findViewById(R.id.fa_btn);
        bl_text=findViewById(R.id.bl_text);
        bl=findViewById(R.id.bl_btn);
        dialogbuilder.setView(dilaog_sc);
        dialog=dialogbuilder.create();
        dialog.setCanceledOnTouchOutside(false);

        dialog.show();
    }


}