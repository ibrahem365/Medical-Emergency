package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class main_screen extends AppCompatActivity {
Button blood_btn;
Button report_btn;
Button fa_btn;
Button emg_btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        blood_btn=findViewById(R.id.button_blood);
        report_btn=findViewById(R.id.button2);
        fa_btn=findViewById(R.id.button);
        emg_btn=findViewById(R.id.button7);

        blood_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(main_screen.this,bloodbank_recycle.class);
                startActivity(t);
            }
        });
        report_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(main_screen.this,new_report.class);
                startActivity(t);
            }
        });

        report_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(main_screen.this,new_report.class);
                startActivity(t);
            }
        });
        report_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(main_screen.this,new_report.class);
                startActivity(t);
            }
        });

        fa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(main_screen.this,first_aid_lv.class);
                startActivity(t);
            }
        });
        emg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(main_screen.this,emgnum_listview.class);
                startActivity(t);
            }
        });

    }
}