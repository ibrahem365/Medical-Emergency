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
Button emg_btn;
Button nearst_btn;
Button recieve_btn ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        nearst_btn=findViewById(R.id.button_nearst);

        recieve_btn = findViewById(R.id.button_receiving) ;

        blood_btn=findViewById(R.id.button_blood);
        report_btn=findViewById(R.id.button2);
        emg_btn=findViewById(R.id.button7);

        recieve_btn.setVisibility(View.GONE);
       // if(user.equals(this will be authorized user verification ))
        //    recieve_btn.setVisibility(View.VISIBLE);  if its مسعف



    }
}