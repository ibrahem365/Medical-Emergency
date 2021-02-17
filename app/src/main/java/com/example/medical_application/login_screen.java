package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login_screen extends AppCompatActivity {
Button sign_in;
    Button first_aid;
    Button emg_num;
    Button medic;
    Button user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        sign_in=findViewById(R.id.signin_btn);
        first_aid=findViewById(R.id.fa_btn);
      emg_num=findViewById(R.id.emg_btn);
        medic=findViewById(R.id.paramedic);
        user=findViewById(R.id.user);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login_screen.this,main_screen.class);
                startActivity(i);


            }
        });
     first_aid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login_screen.this,first_aid_lv.class);
                startActivity(i);

            }
        });
        emg_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login_screen.this,emgnum_listview.class);
                startActivity(i);

            }
        });
        medic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login_screen.this,signup_medic.class);
                startActivity(i);

            }
        });
       user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login_screen.this,signup_user.class);
                startActivity(i);

            }
        });
    }
}