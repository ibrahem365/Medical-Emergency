package com.example.medical_application.Profiles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.medical_application.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class medic_prof_edit extends AppCompatActivity {
    private EditText name,phone,governorate,city,numberambulance,numberbeds,numbercareroom;
    private Button para_updat;
    private FirebaseDatabase database;
    private DatabaseReference UserRef;
    public static final String user="ParamedicUser";
    private String pfullname,pphone,pgovernorte,pcity,pnamberbeds,pnammercareroom,pnamberambluance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medic_prof_edit);

        //inflat items

        name=findViewById(R.id.upname);
        phone=findViewById(R.id.upphone);
        governorate=findViewById(R.id.upgovernorate);
        city=findViewById(R.id.upcity);
        numberambulance=findViewById(R.id.nummber_ambulanc);
        numberbeds=findViewById(R.id.number_bed);
        numbercareroom=findViewById(R.id.number_careroom);
        para_updat=findViewById(R.id.medic_update);

        //data base
       para_updat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String upname_p=name.getText().toString();
                final String upphone_p=phone.getText().toString();
                final String upgovernorate_p=governorate.getText().toString();
                final String upcity_p=city.getText().toString();
                final String upnamberamulance_p=numberambulance.getText().toString();
                final String upnamberbed_p=numberbeds.getText().toString();
                final String upnambercareroom_p=numbercareroom.getText().toString();
                if (upname_p.isEmpty()) {
                    name.setError("enter your name");
                    name.requestFocus();
                    return;
                }
                if(upphone_p.isEmpty()) {
                    phone.setError("enter your number phone");
                    phone.requestFocus();
                }
                if (upgovernorate_p.isEmpty()) {
                    governorate.setError("enter your governorate");
                    governorate.requestFocus();
                    return;
                }
                if (upcity_p.isEmpty()) {
                    city.setError("enter your city");
                    city.requestFocus();
                    return;
                }
                if (upnamberamulance_p.isEmpty()) {
                    numberambulance.setError("enter your  namber of amublance");
                    numberambulance.requestFocus();
                    return;
                }
                if (upnamberbed_p.isEmpty()) {
                    numberbeds.setError("enter your namber of beds");
                    numberbeds.requestFocus();
                    return;
                }
                if (upnambercareroom_p.isEmpty()) {
                    numbercareroom.setError("enter your namber of care room");
                    numbercareroom.requestFocus();
                    return;
                }
                database =FirebaseDatabase.getInstance();
                UserRef=database.getReference();
                String ID = FirebaseAuth.getInstance().getCurrentUser().getUid();
                UserRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot ds : snapshot.getChildren())
                        {
                            pfullname =ds.child("FullName").getValue(String.class);
                            pphone=ds.child("PhoneNumber").getValue(String.class);
                            pgovernorte=(ds.child("Governorate").getValue(String.class));
                            pcity=ds.child("City").getValue(String.class);
                            pnamberambluance=ds.child("NumberBeds").getValue(String.class);
                            pnammercareroom=ds.child("NumberCareRooms").getValue(String.class);
                            pnamberambluance=ds.child("NumberAmbulances").getValue(String.class);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                HashMap map =new HashMap();
                map.replace(pfullname,upname_p);
                map.replace(pphone,upphone_p);
                map.replace(pgovernorte,upgovernorate_p);
                map.replace(pcity,upcity_p);
                map.replace(pnamberambluance,upnamberamulance_p);
                map.replace(pnammercareroom,upnambercareroom_p);
                map.replace(pnamberbeds,upnamberbed_p);
                UserRef.child(ID).updateChildren(map);
                Toast.makeText(medic_prof_edit.this ," تم تعديل البيانات ",Toast.LENGTH_LONG).show();




            }
        });

           

    }
}