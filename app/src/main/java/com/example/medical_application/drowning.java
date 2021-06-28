package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class drowning extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drowning);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView =findViewById(R.id.textview);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}