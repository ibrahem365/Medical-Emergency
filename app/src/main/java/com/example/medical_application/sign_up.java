package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class sign_up extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton user,para;
    LinearLayout userinfo,prainfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        radioGroup=findViewById(R.id.radiogroup);
        user=findViewById(R.id.user);
        para=findViewById(R.id.para);
        userinfo=findViewById(R.id.userinfo);
        prainfo=findViewById(R.id.parainfo);
        userinfo.setVisibility(View.GONE);
        prainfo.setVisibility(View.GONE);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(user.isChecked())
                {
                    userinfo.setVisibility(View.VISIBLE);
                    prainfo.setVisibility(View.GONE);



                    // do something
                }

                if(para.isChecked())
                {
                    userinfo.setVisibility(View.GONE);
                    prainfo.setVisibility(View.VISIBLE);



                    // do something
                }
            }
        });

    }
}