package com.example.medical_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.concurrent.Executor;


public class medic_prof_frag extends Fragment {
    private TextView fullname_tv,phone_tv,address_tv,city_tv,numberAmbulace_tv,numberCareroom_tv,numberBed_tv;
    /*private FirebaseAuth DBauth;
    private FirebaseFirestore DBstore ;
    private DocumentReference docRef;*/
    private FirebaseDatabase database;
    private DatabaseReference UserRef;
    public static final String user="ParamedicUser";



    FloatingActionButton prof_editbtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v= inflater.inflate(R.layout.medic_prof_frag,container,false);
        prof_editbtn=v.findViewById(R.id.medicedit_btn);
        prof_editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity().getBaseContext(),medic_prof_edit.class);
                startActivity(i);
            }
        });
        fullname_tv=v.findViewById(R.id.medic_fullname);
        phone_tv=v.findViewById(R.id.medic_phone);
        address_tv=v.findViewById(R.id.medic_address);
        city_tv=v.findViewById(R.id.medic_city);
        numberAmbulace_tv=v.findViewById(R.id.medic_ambulace);
        numberBed_tv=v.findViewById(R.id.medic_bed);
        numberCareroom_tv=v.findViewById(R.id.medic_rooms);

        //display data

        database =FirebaseDatabase.getInstance();
        UserRef=database.getReference(user);
      UserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren())
                {
                    fullname_tv.setText(ds.child("FullName").getValue(String.class));
                    phone_tv.setText(ds.child("Numberphone").getValue(String.class));
                    address_tv.setText(ds.child("Governorate").getValue(String.class));
                    city_tv.setText(ds.child("City").getValue(String.class));
                    numberAmbulace_tv.setText(ds.child("NumberAmbulances").getValue(String.class));
                    numberBed_tv.setText(ds.child("NumberBeds").getValue(String.class));
                    numberCareroom_tv.setText(ds.child("NumberCareRooms").getValue(String.class));


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        return v;
    }
}
