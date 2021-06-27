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
import android.widget.Toast;


import com.example.medical_application.Database.DatabaseUser;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.regex.Pattern;

import static com.example.medical_application.R.id.p;

public class sign_up extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton  user, para;
    LinearLayout userinfo, prainfo;

    //declear variabels
    private Button btn_register;
    private EditText et_fullname, et_email, et_password, et_governorate, et_city ,et_numberphone;
    // para
    private  EditText et_numAmblanc , et_numBed, et_numCareroom;
    //user
    private  EditText et_age,et_length,et_weight;
    private  Spinner sp_sex ,sp_blood;
    private   CheckBox cb_diabetic,cb_bloodpressure,cb_heartpation;
    private CheckBox checkBox_diseases;
    private  EditText et_didiseases;
    private String item_select_gender;
    private String item_select_bloodtpye;
    private String  userType;
    private FirebaseDatabase db_real_time =FirebaseDatabase.getInstance();
    private DatabaseReference root;
    private FirebaseUser current_user;
    private  String userID;




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
        et_numberphone=findViewById(R.id.numberphone);
        et_password =  findViewById(R.id.et_pass);
        et_governorate = findViewById(R.id.et_Governorate);
        et_city = findViewById(R.id.et_city);


        btn_register = findViewById(R.id.btn_register);

        //iflate items  regster para

        et_numAmblanc=findViewById(R.id.nummber_ambulanc);
        et_numBed=findViewById(R.id.number_bed);
        et_numCareroom=findViewById(R.id.number_careroom);

        //iflate items  register user

        et_age=findViewById(R.id.et_age);
        et_length=findViewById(R.id.et_length);
        et_weight=findViewById(R.id.et_weight);
        cb_diabetic=findViewById(R.id.cb_diabetic) ;
        cb_bloodpressure=findViewById(R.id.cb_blood_pressure);
        cb_heartpation=findViewById(R.id.cb_heart);
        checkBox_diseases=findViewById(R.id.cb_diseases);
        et_didiseases=findViewById(R.id.et_diseases);
        sp_sex=findViewById(R.id.sp_sex);
        sp_blood=findViewById(R.id.sp_blood);
        sp_sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item_select_gender=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp_blood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item_select_bloodtpye=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //to string  register

                final String fullName = et_fullname.getText().toString();
                final String e_mail = et_email.getText().toString();
                final String numberphone=et_numberphone.getText().toString();
                final String passWord = et_password.getText().toString();
                final String governorate = et_governorate.getText().toString();
                final String city = et_city.getText().toString();
                //to string  para register
                final String numberAmblanc =et_numAmblanc.getText().toString();
                final String numberBeds =et_numBed.getText().toString();
                final String numberCareroom=et_numAmblanc.getText().toString();
                //to string  user  register
                final String age=et_age.getText().toString();
                final String length=et_length.getText().toString();
                final String weight=et_weight.getText().toString();
                final String diabetic;if(cb_diabetic.isChecked()) {
                diabetic="yes";
            }else diabetic="no";
                final String bloodPressure;if(cb_bloodpressure.isChecked()){
                bloodPressure="yes";
            }else bloodPressure="no";
                final String heartPatient;if (cb_heartpation.isChecked()){
                heartPatient="yes";
            }else heartPatient="no";
                final String  diseases;if(checkBox_diseases.isChecked()) {
                diseases=et_didiseases.toString();
            }else diseases="null";
               final  String gender =item_select_gender;
               final String bloodType=item_select_bloodtpye;
               if(user.isChecked()){
                   userType="normaluser";
               }
               if(para.isChecked()){
                   userType="paramedicuser";
               }
                //informeation for register error

                if (fullName.isEmpty()) {
                    et_fullname.setError("enter your name");
                    et_fullname.requestFocus();
                    return;
                }
                if(numberphone.isEmpty())
                {
                    et_numberphone.setError("enter your number phone");
                    et_numberphone.requestFocus();
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
                if(para.isChecked()) {
                    userinfo.setVisibility(View.GONE);
                    prainfo.setVisibility(View.VISIBLE);
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
                }

                //user register error
                if(user.isChecked()) {
                    userinfo.setVisibility(View.VISIBLE);
                    prainfo.setVisibility(View.GONE);
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
                }

                //code  auth data base para
                current_user=FirebaseAuth.getInstance().getCurrentUser();
                //userID=current_user.getUid();
                mAuth.createUserWithEmailAndPassword(e_mail,passWord)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {

                                    DatabaseUser users=new DatabaseUser(e_mail,passWord,userType);
                                    FirebaseDatabase.getInstance().getReference("E-mail,Password")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (para.isChecked())
                                            {
                                                root=db_real_time.getReference().child("ParamedicUser");
                                                HashMap<String,String> paramedic_user=new HashMap<>();
                                                paramedic_user.put("UserType ",userType);
                                                paramedic_user.put("FullName",fullName);
                                                paramedic_user.put("Numberphone",numberphone);
                                                paramedic_user.put("Governorate",governorate);
                                                paramedic_user.put("City",city);
                                                paramedic_user.put("NumberAmbulances",numberAmblanc);
                                                paramedic_user.put("NumberBeds",numberBeds);
                                                paramedic_user.put("NumberCareRooms",numberCareroom);
//                                                root.child(userID).setValue(paramedic_user);
                                                root.push().setValue(paramedic_user);

                                            }
                                             if(user.isChecked()){
                                                root=db_real_time.getReference().child("NormalUser");
                                                HashMap<String,String> normal_user=new HashMap<>();
                                                normal_user.put("UserType ",userType);
                                                normal_user.put("FullName",fullName);
                                                normal_user.put("PhoneNumber",numberphone);
                                                normal_user.put("Governorate",governorate);
                                                normal_user.put("City",city);
                                                normal_user.put("Age",age);
                                                normal_user.put("Length",length);
                                                normal_user.put("Weight",weight);
                                                normal_user.put("NBloodType",bloodType);
                                                normal_user.put("Gender",gender);
//                                                root.child(userID).setValue(normal_user);
                                                 root.push().setValue(normal_user);

                                            }

                                        }
                                    });
                                }
                            }
                        });








                Toast.makeText(sign_up.this ," تم اضافتك  ",Toast.LENGTH_LONG).show();
            }


        });



    }
}