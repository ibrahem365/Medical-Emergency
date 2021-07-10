package com.example.medical_application.FirstAid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.medical_application.R;

public class explosion_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explosion_act);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}