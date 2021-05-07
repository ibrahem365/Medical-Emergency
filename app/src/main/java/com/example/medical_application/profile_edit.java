package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class profile_edit extends AppCompatActivity {
     private EditText name,phone,governorate, city,age,lenthg,weight;
     private Spinner gender, bloodtype;
    private Button user_udate;
    private String selectGender, selectBloodType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);


        //inflate icon

        name=findViewById(R.id.udatename);
        phone=findViewById(R.id.updatephone);
        governorate=findViewById(R.id.updategovernorate);
        city=findViewById(R.id.updatecity);
        age=findViewById(R.id.updateage);
        lenthg=findViewById(R.id.updatelenthg);
        weight=findViewById(R.id.updateweight);
        gender=findViewById(R.id.update_sp_sex);
        bloodtype=findViewById(R.id.update_sp_blood);
        //item select to string
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               selectGender=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        bloodtype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectBloodType=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        user_udate=findViewById(R.id.user_update);





    }
}