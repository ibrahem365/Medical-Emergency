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
import com.google.firebase.auth.FirebaseUser;
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

public class profilefragment extends Fragment {
  FloatingActionButton edit_btn;



    private FirebaseDatabase database;
    private  DatabaseReference UserRef;
    public static final String user="NormalUser";

    private  String userID;
    private TextView fullname_tv,phone_tv,address_tv ,city_tv,age_tv ,gender_tv,lenthg_tv,weight_tv,blooatype_tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      final View v= inflater.inflate(R.layout.profile_fragment,container,false);
        edit_btn=v.findViewById(R.id.edit_btn);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity().getBaseContext(),profile_edit.class);
                startActivity(i);
            }
        });



        fullname_tv=v.findViewById(R.id.fullname);
        phone_tv=v.findViewById(R.id.phone);
        address_tv=v.findViewById(R.id.address);
        city_tv=v.findViewById(R.id.city);
        age_tv=v.findViewById(R.id.age);
        gender_tv=v.findViewById(R.id.gender);
        lenthg_tv=v.findViewById(R.id.length);
        weight_tv=v.findViewById(R.id.weight);
        blooatype_tv=v.findViewById(R.id.bloodtype);
        // display data
        database =FirebaseDatabase.getInstance();
        UserRef=database.getReference(user);
        UserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren())
                {
                    fullname_tv.setText(ds.child("FullName").getValue(String.class));
                    phone_tv.setText(ds.child("PhoneNumber").getValue(String.class));
                    address_tv.setText(ds.child("Governorate").getValue(String.class));
                    city_tv.setText(ds.child("City").getValue(String.class));
                    age_tv.setText(ds.child("Age").getValue(String.class));
                    gender_tv.setText(ds.child("Gender").getValue(String.class));
                    lenthg_tv.setText(ds.child("Length").getValue(String.class));
                    weight_tv.setText(ds.child("Weight").getValue(String.class));
                    blooatype_tv.setText(ds.child("NBloodType").getValue(String.class));




                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });











       return v;

    }


}
