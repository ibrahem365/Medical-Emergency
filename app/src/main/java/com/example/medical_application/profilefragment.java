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
  private FirebaseAuth DBauth;
  private   FirebaseFirestore DBstore ;
  private DocumentReference docRef;

   String normal_userId;



    private  String userID;
    private TextView fullname_tv,phone_tv,address_tv,age_tv ,gender_tv,lenthg_tv,weight_tv,blooatype_tv;

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



        /*fullname_tv=v.findViewById(R.id.fullname);
        phone_tv=v.findViewById(R.id.phone);
        address_tv=v.findViewById(R.id.address);
        age_tv=v.findViewById(R.id.age);
        gender_tv=v.findViewById(R.id.gender);
        lenthg_tv=v.findViewById(R.id.length);
        weight_tv=v.findViewById(R.id.weight);
        blooatype_tv=v.findViewById(R.id.bloodtype);
        //data base
        DBauth= FirebaseAuth.getInstance();
        DBstore=FirebaseFirestore.getInstance();
       normal_userId=DBauth.getCurrentUser().getUid();
        docRef = DBstore.collection("Normal User").document(normal_userId);

       docRef.addSnapshotListener((Executor) this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
           fullname_tv.setText(value.getString("N_FullName"));
           phone_tv.setText(value.getString("N_PhoneNumber"));
            String governorate=value.getString("N_Governorate");
            String city=value.getString("N_City");
            String address=governorate +" "+city;
            address_tv.setText(address);
           age_tv.setText(value.getString("N_Age"));
           gender_tv.setText(value.getString("N_Gender"));
           lenthg_tv.setText(value.getString("N_length"));
           weight_tv.setText(value.getString("N_weight"));
           blooatype_tv.setText(value.getString("N_BloodType"));



            }
        });

         */









       return v;

    }


}
