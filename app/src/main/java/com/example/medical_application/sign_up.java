package com.example.medical_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;


import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

import static com.example.medical_application.R.id.sw_blood_pressure;

public class sign_up extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton  user, para;
    LinearLayout userinfo, prainfo;

    //declear variabels
     private Button btn_register;
    private EditText et_fullname, et_email, et_password, et_governorate, et_city ;
    // para
    private  EditText et_numAmblanc , et_numBed, et_numCareroom;
    //user
    private  EditText et_age,et_length,et_weight;
    private  Spinner sp_sex ,sp_blood;
    private Switch sw_diabetic,sw_bloodpressure,sw_heartpation;
    private CheckBox checkBox_diseases;
    private  EditText et_didiseases;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final FirebaseAuth mAuth;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        radioGroup = findViewById(R.id.radiogroup);
        user = findViewById(R.id.user);
        para = findViewById(R.id.para);
        userinfo = findViewById(R.id.userinfo);
        prainfo = findViewById(R.id.parainfo);
        userinfo.setVisibility(View.GONE);
        prainfo.setVisibility(View.GONE);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (user.isChecked()) {
                    userinfo.setVisibility(View.VISIBLE);
                    prainfo.setVisibility(View.GONE);



                }

                if (para.isChecked()) {
                    userinfo.setVisibility(View.GONE);
                    prainfo.setVisibility(View.VISIBLE);


                    // do something
                }
            }
        });
       //database
        mAuth = FirebaseAuth.getInstance();

        //iflate items register

        et_fullname =  findViewById(R.id.full_name);
        et_email = findViewById(R.id.et_email);
        et_password =  findViewById(R.id.et_pass);
        et_governorate = findViewById(R.id.et_Governorate);
        et_city = findViewById(R.id.et_city);

        btn_register = findViewById(R.id.btn_register);

        //iflate items  regster para

        et_numAmblanc=findViewById(R.id.nummber_ambulanc);
        et_numBed=findViewById(R.id.number_bed);
        et_numCareroom=findViewById(R.id.number_careroom);

        //iflate items  register user
         /*
        et_age=findViewById(R.id.et_age);
        et_length=findViewById(R.id.et_length);
        et_weight=findViewById(R.id.et_weight);
        sw_diabetic=findViewById(R.id.sw_diabetic) ;
        sw_bloodpressure=findViewById(sw_blood_pressure);
        sw_heartpation=findViewById(R.id.sw_heart);
        checkBox_diseases=findViewById(R.id.cb_diseases);
        et_didiseases=(EditText)findViewById(R.id.et_diseases);
        sp_sex=(Spinner)findViewById(R.id.sp_sex);
        sp_blood=(Spinner)findViewById(R.id.sp_blood);

          */

/*
         sp_sex.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 final   String item_gender=parent.getItemAtPosition(position).toString();
             }
         });
        sp_blood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  final  String item_bloodtype  =parent.getItemAtPosition(position).toString();
            }
        });

 */







        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //to string  register

                final String fullName = et_fullname.getText().toString().trim();
                final String e_mail = et_email.getText().toString().trim();
                final String passWord = et_password.getText().toString().trim();
                final String governorate = et_governorate.getText().toString().trim();
                final String city = et_city.getText().toString().trim();

                //to string  para register


                final String numberAmblanc =et_numAmblanc.getText().toString().trim();
                final String numberBeds =et_numBed.getText().toString().trim();
                final String numberCareroom=et_numAmblanc.getText().toString().trim();


                //to string  user  register

                 /*
              final String age=et_age.getText().toString().trim();
              final String length=et_length.getText().toString().trim();
              final String weight=et_weight.getText().toString().trim();
              final String diabetic;if(sw_diabetic.isChecked()) {
                    diabetic="yes";
                }else diabetic="no";
              final String bloodPressure;if(sw_bloodpressure.isChecked()){
                    bloodPressure="yes";
                }else bloodPressure="no";
              final String heartPatient;if (sw_heartpation.isChecked()){
                    heartPatient="yes";
                }else heartPatient="no";
              final String  diseases;if(checkBox_diseases.isChecked()) {
                    diseases=et_didiseases.toString();
                }else diseases="null";
             //المتغيرين دول مش null في مشكل spinner
              final String gender ="null";
              final String bloodType="null";

                  */




                //informeation for register error

                if (fullName.isEmpty()) {
                    et_fullname.setError("enter your name");
                    et_fullname.requestFocus();
                    return;
                }
                if (e_mail.isEmpty()) {
                    et_email.setError("enter your e-mail");
                    et_email.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(e_mail).matches()) {
                    et_email.setError("ee-mail is wrong");
                    et_email.requestFocus();
                    return;


                }
                if (passWord.isEmpty()) {
                    et_password.setError("enter your password");
                    et_password.requestFocus();
                    return;
                }
                if(passWord.length() <8) {
                    et_password.setError(" password is short should be 8 character");
                    et_password.requestFocus();
                    return;
                }
                if (governorate.isEmpty()) {
                    et_governorate.setError("enter your governorate");
                    et_governorate.requestFocus();
                    return;
                }
                if (city.isEmpty()) {
                    et_city.setError("enter your city");
                    et_city.requestFocus();
                    return;
                }

                //para register error

                if (numberAmblanc.isEmpty()) {
                    et_numAmblanc.setError("Enter number ambulance");
                    et_numAmblanc.requestFocus();
                    return;

                }
                if (numberBeds.isEmpty()) {
                   et_numBed.setError("Enter number Beds");
                    et_numBed.requestFocus();
                    return;

                }
                if (numberCareroom.isEmpty()) {
                    et_numCareroom.setError("Enter number carerooms");
                    et_numCareroom.requestFocus();
                    return;

                }
                //user register error
                /*
                if(age.isEmpty()) {
                    et_age.setError("enter age ");
                    et_age.requestFocus();
                    return;
                }
                if(length.isEmpty()) {
                    et_age.setError("enter length ");
                    et_age.requestFocus();
                    return;
                }
                if(weight.isEmpty()) {
                    et_age.setError("enter weight ");
                    et_age.requestFocus();
                    return;
                }

                 */

                //code data base para


                mAuth.createUserWithEmailAndPassword(e_mail,passWord)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    para_medic_database para=new para_medic_database(fullName,e_mail,passWord,governorate,city,numberAmblanc,numberBeds,numberCareroom);
                                    FirebaseDatabase.getInstance().getReference("para medic")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(para).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                        }
                                    });
                                }
                            }
                        });

                // code date base user

                 // this is problem here
                /*
                mAuth.createUserWithEmailAndPassword(e_mail,passWord)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    user_database user =new user_database(fullName,e_mail,passWord,governorate,city,age,length,weight,diabetic,bloodPressure,heartPatient,diseases,gender,bloodType);
                                    FirebaseDatabase.getInstance().getReference("user ")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                           .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                        }
                                    });
                                }
                            }
                        });

                 */



            }


        });


       
    }
}