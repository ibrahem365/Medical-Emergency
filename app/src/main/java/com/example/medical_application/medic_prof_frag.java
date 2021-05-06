package com.example.medical_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class medic_prof_frag extends Fragment {
    Button prof_editbtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.medic_prof_frag,container,false);
        prof_editbtn=v.findViewById(R.id.medicedit_btn);
        prof_editbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity().getBaseContext(),medic_prof_edit.class);
                startActivity(i);
            }
        });
        return v;
    }
}
