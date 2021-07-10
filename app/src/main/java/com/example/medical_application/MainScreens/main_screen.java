package com.example.medical_application.MainScreens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.medical_application.R;
import com.example.medical_application.BloodBank.bloodbank_recycle;
import com.example.medical_application.EmerNum.emgnum_listview;
import com.example.medical_application.FirstAid.first_aid_lv;
import com.example.medical_application.NearstCenter.nearst_center;
import com.example.medical_application.Reports.new_report;

public class main_screen extends AppCompatActivity {


Button blood_btn;
Button report_btn;
Button fa_btn;
Button emg_btn;
Button nearst_btn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        nearst_btn=findViewById(R.id.button_nearst);



        blood_btn=findViewById(R.id.button_blood);
        report_btn=findViewById(R.id.button2);
        fa_btn=findViewById(R.id.button);
        emg_btn=findViewById(R.id.button7);
        nearst_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(main_screen.this, nearst_center.class);
                startActivity(t);

            }
        });
        blood_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(main_screen.this, bloodbank_recycle.class);
                startActivity(t);
            }
        });
        report_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(main_screen.this, new_report.class);
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
                Intent t=new Intent(main_screen.this, first_aid_lv.class);
                startActivity(t);
            }
        });
        emg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t=new Intent(main_screen.this, emgnum_listview.class);
                startActivity(t);
            }
        });




    }
}