package com.example.medical_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.medical_application.Adapter.first_aidAdapter;
import com.example.medical_application.UI.Diabetes;
import com.example.medical_application.UI.firstaid_States.airwayobstruction;

import java.util.ArrayList;

public class traffic_accidents extends AppCompatActivity {
    private first_aidAdapter adapter;

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_accidents);
        lv=findViewById(R.id.fa_lv);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        final ArrayList<fa_info> fa_infos = new ArrayList<>();

        fa_infos.add(new fa_info(R.drawable.modadalaelard2, R.string.item_title_momdadalaelard,R.string.item_disc_fahs));
        fa_infos.add(new fa_info(R.drawable.ksoor100, R.string.item_title_ksoor,R.string.item_disc_ksoor));
        fa_infos.add(new fa_info(R.drawable.daghtat, R.string.item_title_enashkalby,R.string.item_disc_enash));
        fa_infos.add(new fa_info(R.drawable.yanzefbeghzara, R.string.item_title_yanzefbaghzara,R.string.item_dis_cynzef));
        fa_infos.add(new fa_info(R.drawable.hrook100, R.string.item_title_hrook,R.string.item_disc_hrook));

        final first_aidAdapter adapter = new first_aidAdapter(this, R.layout.fa_lv_item_layout, fa_infos);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent i=new Intent(traffic_accidents.this,qucik_check.class);
                    startActivity(i);
                }
                if(position==1){
                    Intent i=new Intent(traffic_accidents.this,fractures.class);
                    startActivity(i);
                }
                if(position==2){
                    Intent i=new Intent(traffic_accidents.this,bleeds_profusely.class);
                    startActivity(i);
                }
                if(position==3){
                    Intent i=new Intent(traffic_accidents.this,burns.class);
                    startActivity(i);
                }


            }
        });



    }
}