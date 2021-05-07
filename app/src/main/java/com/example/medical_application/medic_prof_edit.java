package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class medic_prof_edit extends AppCompatActivity {
    private EditText name,phone,governorate,city,numberambulance,numberbeds,numbercareroom;
    private Button para_updat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medic_prof_edit);

        //inflat items

        name=findViewById(R.id.upname);
        phone=findViewById(R.id.upphone);
        governorate=findViewById(R.id.upgovernorate);
        city=findViewById(R.id.upcity);
        numberambulance=findViewById(R.id.nummber_ambulanc);
        numberbeds=findViewById(R.id.number_bed);
        numbercareroom=findViewById(R.id.number_careroom);
        para_updat=findViewById(R.id.medic_update);
    }
}