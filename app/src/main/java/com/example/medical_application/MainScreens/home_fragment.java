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

import com.example.medical_application.BloodBank.bloodbank_recycle;
import com.example.medical_application.EmerNum.emgnum_listview;
import com.example.medical_application.FirstAid.first_aid_lv;
import com.example.medical_application.R;
import com.example.medical_application.NearstCenter.nearst_center;
import com.example.medical_application.Reports.new_report;

public class home_fragment extends Fragment {
    Button faa_btn,emnu_btn,bloodb_btn,near_btn,nrepoort_btn;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View v= inflater.inflate(R.layout.home_fragment,container,false);
      faa_btn=v.findViewById(R.id.fai_btn);
      nrepoort_btn=v.findViewById(R.id.nreport_btn);
     emnu_btn=v.findViewById(R.id.emnu_btn);
        near_btn=v.findViewById(R.id.near_btn);
        bloodb_btn=v.findViewById(R.id.bblood_btn);

        faa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity().getBaseContext(), first_aid_lv.class);
                startActivity(i);
            }
        });
     emnu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity().getBaseContext(), emgnum_listview.class);
                startActivity(i);
            }
        });
       near_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity().getBaseContext(), nearst_center.class);
                startActivity(i);
            }
        });
       nrepoort_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity().getBaseContext(), new_report.class);
                startActivity(i);
            }
        });
      bloodb_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity().getBaseContext(), bloodbank_recycle.class);
                startActivity(i);
            }
        });
//reportrec_btn.setVisibility(View.GONE);

      return v;


    }


}
