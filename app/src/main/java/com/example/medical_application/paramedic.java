package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class paramedic extends AppCompatActivity {

    Button first_aids ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paramedic);

        first_aids = findViewById(R.id.firstaid_states);

        first_aids.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent para;
                para = new Intent(getBaseContext(),first_aid_lv.class);
                startActivity(para);

            }
        });


    }
}