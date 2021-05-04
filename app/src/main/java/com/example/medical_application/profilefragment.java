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

public class profilefragment extends Fragment {
  FloatingActionButton edit_btn;
    private FirebaseUser user ;
    private DatabaseReference reference;
    private  String userID;
    private TextView fullname_tv,email_tv,address_tv,age_tv ,gender_tv,lenthg_tv,weight_tv,blooatype_tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View v= inflater.inflate(R.layout.profile_fragment,container,false);
        edit_btn=v.findViewById(R.id.edit_btn);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity().getBaseContext(),profile_edit.class);
                startActivity(i);
            }
        });

        /*user = FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("users");
        userID=user.getUid();
        fullname_tv=v.findViewById(R.id.fullname);
        email_tv=v.findViewById(R.id.email);
        address_tv=v.findViewById(R.id.address);
        age_tv=v.findViewById(R.id.age);
        gender_tv=v.findViewById(R.id.gender);
        lenthg_tv=v.findViewById(R.id.length);
        weight_tv=v.findViewById(R.id.weight);
        blooatype_tv=v.findViewById(R.id.bloodtype);
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                user_database userprofile =snapshot.getValue(user_database.class);
                if(userprofile != null)
                {
                    String fregment_fullname=userprofile.fullname;
                    String fregment_email=userprofile.email;
                    String fregment_governorate=userprofile.governorate;
                    String fregment_city=userprofile.city;
                    String fregment_address=fregment_governorate+" "+ fregment_city;
                    String fregment_age=userprofile.age;
                    String fregment_gender=userprofile.gender;
                    String fregment_lenthg=userprofile.length;
                    String fregment_weight=userprofile.weight;
                    String fregment_bloodtype=userprofile.bloodType;
                    //
                    //
                    fullname_tv.setText(fregment_fullname);
                    email_tv.setText(fregment_email);
                    address_tv.setText(fregment_address);
                    age_tv.setText(fregment_age);
                    gender_tv.setText(fregment_gender);
                    lenthg_tv.setText(fregment_lenthg);
                    weight_tv.setText(fregment_weight);
                    blooatype_tv.setText(fregment_bloodtype);


                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

         */



       return v;

    }


}
