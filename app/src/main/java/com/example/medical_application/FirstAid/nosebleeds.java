package com.example.medical_application.FirstAid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.medical_application.R;

public class nosebleeds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nosebleeds);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}