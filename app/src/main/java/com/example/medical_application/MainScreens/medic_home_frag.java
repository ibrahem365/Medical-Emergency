package com.example.medical_application.MainScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.medical_application.EmerNum.emgnum_listview;
import com.example.medical_application.FirstAid.first_aid_lv;
import com.example.medical_application.R;
import com.example.medical_application.Reports.ReceivingReports;

public class medic_home_frag extends Fragment {
    Button famedic,enmumedic,recieve;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.medic_home_frag,container,false);
        famedic=v.findViewById(R.id.famed_btn);
        enmumedic=v.findViewById(R.id.emnumed_btn);
        recieve=v.findViewById(R.id.reciever_btn);
        famedic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity().getBaseContext(), first_aid_lv.class);
                startActivity(i);
            }
        });
        enmumedic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity().getBaseContext(), emgnum_listview.class);
                startActivity(i);
            }
        });
        recieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity().getBaseContext(), ReceivingReports.class);
                startActivity(i);
            }
        });
        return v;
    }
}
