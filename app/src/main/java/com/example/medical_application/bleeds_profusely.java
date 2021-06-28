package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class bleeds_profusely extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bleeds_profusely);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView =findViewById(R.id.textview);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}