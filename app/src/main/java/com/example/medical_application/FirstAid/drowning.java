package com.example.medical_application.FirstAid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.medical_application.R;

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