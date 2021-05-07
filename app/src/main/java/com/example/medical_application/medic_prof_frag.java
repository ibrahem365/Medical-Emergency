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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.concurrent.Executor;


public class medic_prof_frag extends Fragment {
    private TextView fullname_tv,phone_tv,address_tv,numberAmbulace_tv,numberCareroom_tv,numberBed_tv;
    private FirebaseAuth DBauth;
    private FirebaseFirestore DBstore ;
    private DocumentReference docRef;

    String paramedic_userId;

    Button prof_editbtn;
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
        numberAmbulace_tv=v.findViewById(R.id.medic_ambulace);
        numberBed_tv=v.findViewById(R.id.medic_bed);
        numberCareroom_tv=v.findViewById(R.id.medic_rooms);


        DBauth= FirebaseAuth.getInstance();
        DBstore=FirebaseFirestore.getInstance();
        paramedic_userId=DBauth.getCurrentUser().getUid();

        docRef = DBstore.collection("Paramedic User").document(paramedic_userId);
        docRef.addSnapshotListener((Executor) this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                fullname_tv.setText(value.getString("P_FullName"));
                phone_tv.setText(value.getString("P_PhoneNumber"));
                String governorate=value.getString("P_Governorate");
                String city=value.getString("P_City");
                String address=governorate +" "+city;
                address_tv.setText(address);
                numberAmbulace_tv.setText(value.getString("P_NumberAmbulances"));
                numberBed_tv.setText(value.getString("P_NumberBeds"));
                numberCareroom_tv.setText(value.getString("P_NumberCareRooms"));




            }
        });



        return v;
    }
}
