package com.example.medical_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_screen extends AppCompatActivity {
Button sign_in;
    Button first_aid;
    Button emg_num;
    Button medic;
    Button user;
    Button sign_up;
    EditText et_email,et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //database
        final FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        //
        setContentView(R.layout.activity_login_screen);
        sign_in=findViewById(R.id.sigin_btn);
        first_aid=findViewById(R.id.fa_btn);
        emg_num=findViewById(R.id.emg_btn);
       // medic=findViewById(R.id.paramedic);
       // user=findViewById(R.id.user);
        sign_up=findViewById(R.id.signupp_btn);
        et_email=findViewById(R.id.et_email_login);
        et_password=findViewById(R.id.et_pasaword_login);


        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(login_screen.this, sign_up.class);
                startActivity(i);
            }
        });

        //work her

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             String email_login=et_email.getText().toString().trim();
             String password_login=et_password.getText().toString().trim();
                 if(email_login.isEmpty()) {
                 if (email_login.isEmpty()) {
                     et_email.setError("enter your e-mail");
                     et_email.requestFocus();
                     return;
                 }
                 if(!Patterns.EMAIL_ADDRESS.matcher(email_login).matches()) {
                     et_email.setError("ee-mail is wrong");
                     et_email.requestFocus();
                     return;


                 }
             }
                if(!Patterns.EMAIL_ADDRESS.matcher(email_login).matches()) {
                    et_email.setError("e-mail is wrong");
                    et_email.requestFocus();
                    return;


                }
                if (password_login.isEmpty()) {
                    et_password.setError("enter your password");
                    et_password.requestFocus();
                    return;
                }
                if(password_login.length() <8) {
                    et_password.setError(" password is short should be 8 character");
                    et_password.requestFocus();
                    return;
                }

                     mAuth.signInWithEmailAndPassword(email_login,password_login)
                             .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                 @Override
                                 public void onComplete(@NonNull Task<AuthResult> task) {
                                     if(task.isSuccessful())
                                     {

                                        // startActivity(new Intent(login_screen.this,main_screen.class));

                                  // startActivity(new Intent(login_screen.this, main_screen.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                                     }

                                     //else Toast.makeText(login_screen.this ,"login error ",Toast.LENGTH_LONG).show();
                                 }
                             });
                startActivity(new Intent(login_screen.this,nav_drawer.class));





            }
        });
     first_aid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login_screen.this,first_aid_lv.class);
                startActivity(i);

            }
        });
        emg_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(login_screen.this,emgnum_listview.class);
                startActivity(i);

            }
        });
    //    medic.setOnClickListener(new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {
          //      Intent i=new Intent(login_screen.this,signup_medic.class);
               // startActivity(i);

         //   }
       // });
      // user.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
               // Intent i=new Intent(login_screen.this,signup_user.class);
               // startActivity(i);

           // }
      //  });
    }
}